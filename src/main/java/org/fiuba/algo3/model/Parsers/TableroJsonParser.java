package org.fiuba.algo3.model.Parsers;

import org.fiuba.algo3.model.Banco.Banco;
import org.fiuba.algo3.model.Casilleros.*;
import org.fiuba.algo3.model.Casilleros.Inmueble.Inmueble;
import org.fiuba.algo3.model.Casilleros.Inmueble.Vivienda;
import org.fiuba.algo3.model.Tablero.ListaCircular;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.*;


public class TableroJsonParser extends JsonParser {

    private ListaCircular<Casillero> casilleros;

    private Banco banco;

    private Double fianza;

    private CentroDeTransportes centroDeTransportes;

    private HashMap<String, Barrio> barrios;

    private HashMap<Casillero, HashMap<String, String>> infoCasilla;

    private Carcel carcel;

    public TableroJsonParser(String fileName) throws InvalidJson {
        super(fileName);
        this.infoCasilla = new HashMap<>();
        this.casilleros = new ListaCircular<>();
        this.banco = new Banco();
        this.centroDeTransportes = new CentroDeTransportes();
        this.barrios = new HashMap<>();
        this.fianza = 0.0;
        this.carcel = new Carcel();
        this.cargarTablero();
    }

    private void cargarTablero() throws InvalidJson{
        JSONArray tableroJSONArray;

        try {
            String contenidoDeArchivo = this.leerJson();
            tableroJSONArray = new JSONArray(contenidoDeArchivo);
        } catch ( JSONException e ) {
            throw new InvalidJson(e.getMessage());
        }

        for (int i = 0; i < tableroJSONArray.length(); i++){
            JSONObject casilleroJson = tableroJSONArray.getJSONObject(i);
            this.casilleros.append(this.crearCasillero(casilleroJson));
        }

    }

    private Casillero crearCasillero( JSONObject casilleroJson ) throws InvalidJson {
        String tipoCasillero = casilleroJson.getString("tipo");

        switch (tipoCasillero){
            case "propiedad":
                return this.crearCasilleroPropiedad(casilleroJson);
            case "transporte":
                return this.crearCasilleroTransporte(casilleroJson);
            case "de paso":
                return new Casillero();
            case "multa":
                return this.crearCasilleroMulta(casilleroJson);
            case "loteria":
                return this.crearCasilleroLoteria(casilleroJson);
            case "carcel":
                return this.crearCasilleroCarcel(casilleroJson);
            case "ir a la carcel":
                return this.crearCasilleroIrALaCarcel();
            case "inicio":
                return this.crearCasilleroInicio(casilleroJson);
            default:
                throw new InvalidJson("Al menos uno de los tipos especificados en el json, no existe");
        }

    }

    public Double obtenerFianza(){
        return fianza;
    }

    public HashMap<Casillero, HashMap<String,String>> obtenerInfoCasilleros(){
        return this.infoCasilla;
    }

    public ListaCircular<Casillero> obtenerCasilleros(){
        return this.casilleros;
    }

    private Casillero crearCasilleroInicio(JSONObject casilleroJson) {
        Double montoAlPasarPorInicio = casilleroJson.getDouble("monto");
        return new Inicio(montoAlPasarPorInicio, banco);
    }

    private Casillero crearCasilleroIrALaCarcel() {
        return new IrALaCarcel(this.carcel);
    }

    private Casillero crearCasilleroCarcel(JSONObject casilleroJson) {
        this.fianza = casilleroJson.getDouble("fianza");
        return this.carcel;
    }

    private Casillero crearCasilleroLoteria(JSONObject casilleroJson) {
        Double montoACobrar = casilleroJson.getDouble("monto");
        return new Loteria(montoACobrar, banco);
    }

    private Casillero crearCasilleroMulta(JSONObject casilleroJson) {
        Double montoACobrar = casilleroJson.getDouble("monto");
        return new Multa(montoACobrar, banco);
    }

    private Casillero crearCasilleroTransporte(JSONObject casilleroJson) {
        String nombreTransporte = casilleroJson.getString("nombre");
        Double precioCompraTransporte = casilleroJson.getDouble("precio");
        Double precioRentaTransporte = casilleroJson.getDouble("renta");
        Transporte transporte = new Transporte(nombreTransporte,precioCompraTransporte, precioRentaTransporte, centroDeTransportes);
        this.centroDeTransportes.agregarTransporte(transporte);
        return transporte;
    }

    private Casillero crearCasilleroPropiedad(JSONObject casilleroJson) {
        String nombrePropiedad = casilleroJson.getString("nombre");
        Double costoDeVenta = casilleroJson.getDouble("precio");
        String color = casilleroJson.getString("color");
        this.barrios.putIfAbsent(color, new Barrio(color, banco));
        Barrio barrio = this.barrios.get(color);
        JSONObject preciosDeVentaInmuebles = casilleroJson.getJSONObject("precio venta viviendas");
        ArrayList<Inmueble> inmuebles = this.obtenerInmuebles(preciosDeVentaInmuebles);
        JSONObject preciosDeRentasPorCantidadDeInmuebles = casilleroJson.getJSONObject("rentas");
        ArrayList<Double> preciosRentas = this.obtenerPrecios(preciosDeRentasPorCantidadDeInmuebles);
        JSONObject preciosDeCompraInmuebles = casilleroJson.getJSONObject("precio compra viviendas");
        ArrayList<Double> preciosDeCompra = this.obtenerPrecios(preciosDeCompraInmuebles);
        Propiedad propiedad = new Propiedad(nombrePropiedad, costoDeVenta,barrio,inmuebles,preciosRentas,preciosDeCompra, banco);
        barrio.agregarPropiedad(propiedad);
        HashMap<String, String> infoPropiedad = new HashMap<>();
        infoPropiedad.put("nombre", nombrePropiedad);
        infoPropiedad.put("precio", costoDeVenta.toString());
        infoPropiedad.put("color", color);
        this.infoCasilla.put(propiedad, infoPropiedad);
        return propiedad;
    }

    private ArrayList<Double> obtenerPrecios(JSONObject preciosJson){
        ArrayList<Double> preciosArray = new ArrayList<>();
        Iterator<String> claves = preciosJson.keys();
        while ( claves.hasNext() ){
            Double precio = preciosJson.getDouble(claves.next());
            preciosArray.add(precio);
        }
        return preciosArray;
    }

    private ArrayList<Inmueble> obtenerInmuebles(JSONObject preciosDeVentaInmuebles) {
        ArrayList<Inmueble> inmuebles = new ArrayList<>();
        for ( Double precioDeVenta : this.obtenerPrecios(preciosDeVentaInmuebles) ){
            Inmueble inmueble = new Vivienda(precioDeVenta);
            inmuebles.add(inmueble);
        }
        return inmuebles;
    }

}