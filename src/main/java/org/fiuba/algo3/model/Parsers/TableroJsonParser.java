package org.fiuba.algo3.model.Parsers;

import javafx.scene.paint.Color;
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

    private final Integer DIAS_DE_CONDENA = 5;

    private HashMap<String, Color> coloresDePropiedades;
    private HashMap<String,ArrayList<ArrayList<String>>> preciosInmueblesPorNombreDePropiedad;
    private ArrayList<IrALaCarcel> casillerosIrALaCarcel;

    private enum EstadoCreacionCarcel{ NO_SE_CREO_UNA_CARCEL, SE_CREO_UNA_CARCEL, SE_CREO_MAS_DE_UNA_CARCEL};

    private EstadoCreacionCarcel estadoCreacionCarcel;

    public TableroJsonParser(String fileName) throws InvalidJson {
        super(fileName);
        this.coloresDePropiedades =new HashMap<>();
        this.casillerosIrALaCarcel = new ArrayList<>();
        this.preciosInmueblesPorNombreDePropiedad = new HashMap<>();
        this.estadoCreacionCarcel = EstadoCreacionCarcel.NO_SE_CREO_UNA_CARCEL;
        this.infoCasilla = new HashMap<>();
        this.casilleros = new ListaCircular<>();
        this.banco = new Banco();
        this.centroDeTransportes = new CentroDeTransportes();
        this.barrios = new HashMap<>();
        this.fianza = 0.0;
        this.carcel = new Carcel(DIAS_DE_CONDENA);
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

        if( this.estadoCreacionCarcel != EstadoCreacionCarcel.SE_CREO_UNA_CARCEL){
            throw new InvalidJson("El archivo no posee una carcel o no es unica");
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

    public ArrayList<IrALaCarcel> obtenerCasillerosIrALa8Carcel() {
        return this.casillerosIrALaCarcel;
    }

    public ListaCircular<Casillero> obtenerCasilleros(){
        return this.casilleros;
    }

    public Banco obtenerBanco(){
        return this.banco;
    }

    public ArrayList<ArrayList<String>> obtenerInformacionInmueblesSobre(String nombrePropiedad){
        return this.preciosInmueblesPorNombreDePropiedad.get(nombrePropiedad);
    }

    public Color obtenerColorDePropiedad(String nombrePropiedad ){
        return this.coloresDePropiedades.get(nombrePropiedad);
    }

    private Casillero crearCasilleroInicio(JSONObject casilleroJson) {
        Double montoAlPasarPorInicio = casilleroJson.getDouble("monto");
        return new Inicio(montoAlPasarPorInicio, banco);
    }

    private Casillero crearCasilleroIrALaCarcel() {
        this.casillerosIrALaCarcel.add(new IrALaCarcel(this.carcel));
        return this.casillerosIrALaCarcel.getLast();
    }

    private Casillero crearCasilleroCarcel(JSONObject casilleroJson) {
        this.fianza = casilleroJson.getDouble("fianza");

        if(this.estadoCreacionCarcel == EstadoCreacionCarcel.SE_CREO_UNA_CARCEL || this.estadoCreacionCarcel == EstadoCreacionCarcel.SE_CREO_MAS_DE_UNA_CARCEL)
            this.estadoCreacionCarcel = EstadoCreacionCarcel.SE_CREO_MAS_DE_UNA_CARCEL;
        else
            this.estadoCreacionCarcel = EstadoCreacionCarcel.SE_CREO_UNA_CARCEL;

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

    private Casillero crearCasilleroPropiedad(JSONObject casilleroJson) throws InvalidJson {
        String nombrePropiedad = casilleroJson.getString("nombre");
        Double costoDeVenta = casilleroJson.getDouble("precio");
        String color = casilleroJson.getString("color");
        Double precioHipoteca = casilleroJson.getDouble("hipoteca");
        Double precioDehipoteca = casilleroJson.getDouble("deshipoteca");
        this.banco.agregarHipoteca(nombrePropiedad, precioHipoteca);
        this.banco.agregarDeshipoteca(nombrePropiedad, precioDehipoteca);
        this.coloresDePropiedades.put(nombrePropiedad, Color.valueOf(color));
        this.barrios.putIfAbsent(color, new Barrio(color));
        Barrio barrio = this.barrios.get(color);
        JSONArray preciosDeVentaInmuebles = casilleroJson.getJSONArray("precio venta viviendas");
        JSONArray preciosDeRentasPorCantidadDeInmuebles = casilleroJson.getJSONArray("rentas");
        JSONArray preciosDeCompraInmuebles = casilleroJson.getJSONArray("precio compra viviendas");
        ArrayList<Inmueble> inmuebles = this.obtenerInmuebles(nombrePropiedad, preciosDeVentaInmuebles, preciosDeRentasPorCantidadDeInmuebles, preciosDeCompraInmuebles);
        Propiedad propiedad = new Propiedad(nombrePropiedad, costoDeVenta,barrio,inmuebles, banco);
        barrio.agregarPropiedad(propiedad);
        HashMap<String, String> infoPropiedad = new HashMap<>();
        infoPropiedad.put("nombre", nombrePropiedad);
        infoPropiedad.put("precio", costoDeVenta.toString());
        infoPropiedad.put("color", color);
        this.infoCasilla.put(propiedad, infoPropiedad);
        return propiedad;
    }

    private ArrayList<String> cambiarElementosACadena( ArrayList<Double> elementos ){
        ArrayList<String> elementosEnCadenas = new ArrayList<>();
        for ( Double elemento: elementos ){
            elementosEnCadenas.add(elemento.toString());
        }
        return elementosEnCadenas;
    }

    private ArrayList<Double> obtenerPrecios(JSONArray preciosJson){
        ArrayList<Double> preciosArray = new ArrayList<>();

        for ( int i = 0; i < preciosJson.length(); i++ ){
            Double precio = preciosJson.getDouble(i);
            preciosArray.add(precio);
        }

        return preciosArray;
    }

    private ArrayList<Inmueble> obtenerInmuebles(String nombrePropiedad, JSONArray preciosDeVentaInmuebles, JSONArray preciosDeRentasPorCantidadDeInmuebles, JSONArray preciosDeCompraInmuebles) throws InvalidJson {
        ArrayList<Inmueble> inmuebles = new ArrayList<>();
        ArrayList<Double> preciosDeVenta = this.obtenerPrecios(preciosDeVentaInmuebles);
        ArrayList<Double> preciosDeCompra = this.obtenerPrecios(preciosDeCompraInmuebles);
        ArrayList<Double> preciosDeRentas = this.obtenerPrecios(preciosDeRentasPorCantidadDeInmuebles);

        agregarADiccionarioDePreciosInmuebles(nombrePropiedad, preciosDeRentas, preciosDeCompra, preciosDeVenta);

        if( preciosDeVenta.size() != preciosDeRentas.size() || preciosDeRentas.size() != preciosDeVenta.size() ){
            throw new InvalidJson("Las cantidades de datos de los precios de las viviendas son erroneos.");
        }

        Double precioRentaAcumulado = 0.0;
        for ( int i = 0; i < preciosDeRentas.size(); i++ ) {
            Double precioDeCompra = preciosDeCompra.get(i);
            Double precioDeVenta = preciosDeVenta.get(i);
            Double precioDeRenta = preciosDeRentas.get(i);
            precioDeRenta = precioDeRenta - precioRentaAcumulado;
            precioRentaAcumulado += precioDeRenta;
            Inmueble inmueble = new Vivienda(precioDeVenta, precioDeCompra, precioDeRenta, this.banco);
            inmuebles.add(inmueble);
        }
        return inmuebles;
    }

    private void agregarADiccionarioDePreciosInmuebles(String nombrePropiedad, ArrayList<Double> preciosDeRentas, ArrayList<Double> preciosDeCompra, ArrayList<Double> preciosDeVenta) {
        ArrayList< ArrayList<String> > preciosInmuebles = new ArrayList<>();
        ArrayList<String> preciosRenta = this.cambiarElementosACadena(preciosDeRentas);
        ArrayList<String> preciosCompra = this.cambiarElementosACadena(preciosDeCompra);
        ArrayList<String> preciosVenta = this.cambiarElementosACadena(preciosDeVenta);
        ArrayList<String> columnaCantidadDeViviendas = new ArrayList<>();
        columnaCantidadDeViviendas.add("Viviendas");
        columnaCantidadDeViviendas.add("0 casas");
        columnaCantidadDeViviendas.add("1 casa");
        columnaCantidadDeViviendas.add("2 casas");
        columnaCantidadDeViviendas.add("3 casas");
        columnaCantidadDeViviendas.add("4 casas");
        columnaCantidadDeViviendas.add("1 hotel");
        preciosRenta.addFirst("Rentas");
        preciosCompra.addFirst("P. Compra");
        preciosVenta.addFirst("P. Venta");
        preciosInmuebles.add(columnaCantidadDeViviendas);
        preciosInmuebles.add(preciosRenta);
        preciosInmuebles.add( preciosCompra);
        preciosInmuebles.add( preciosVenta);
        this.preciosInmueblesPorNombreDePropiedad.put(nombrePropiedad, preciosInmuebles);
    }


    public Carcel obtenerCarcel() {
        return this.carcel;
    }
}