package src.main.java.org.fiuba.algo3.view;

import picocli.CommandLine;

import java.awt.*;
import java.awt.image.BufferedImage;

import static org.jline.jansi.Ansi.ansi;

@CommandLine.Command(name = "ASCIIArt", version = "ASCIIArt 1.0", mixinStandardHelpOptions = true) 
public class ASCIIArt implements Runnable {

    @CommandLine.Option(names = { "-s", "--font-size" }, description = "Font size")
    int fontSize = 18;

    @CommandLine.Parameters(paramLabel = "<word>", defaultValue = "Poly - Morphic",
            description = "Words to be translated into ASCII art.")
    private String[] words = { "Poly-Morphic" };

    @Override
    public void run() {

        BufferedImage image = new BufferedImage(144, 32, BufferedImage.TYPE_INT_RGB);
        Graphics graphics = image.getGraphics();
        graphics.setFont(new Font("Dialog", Font.PLAIN, fontSize));
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        graphics2D.drawString(String.join(" ", words), 6, 24);

        for (int y = 0; y < 32; y++) {
            StringBuilder builder = new StringBuilder();
            for (int x = 0; x < 144; x++)
                builder.append(image.getRGB(x, y) == -16777216 ? " " : image.getRGB(x, y) == -1 ? ( ansi().render("@|green #|@") ): ( ansi().render("@|green #|@") ));
            if (builder.toString().trim().isEmpty()) continue;
            System.out.println(builder);
        }
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new ASCIIArt()).execute(args);
        System.exit(exitCode);
    }
}
