import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class GeradorDeFigurinha {

    public void cria(InputStream inputStream, String nomeArquivo) throws Exception {
        //le imagem

        //InputStream inputStream = FileInputStream(new File("entrada/filme.jpg"));
        //InputStream inputStream = new URL("https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@.jpg").openStream();
        BufferedImage original = ImageIO.read(inputStream);

        //cria nova imagem em memória com transparência e com tamanho novo

        int largura = original.getWidth();
        int altura = original.getHeight();
        int novaAltura = altura + 200;
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);
        
        //copiar a imagem original para nova imagem
        
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(original, 0, 0, null);

        //configurar a fonte

        var font = new Font(Font.SANS_SERIF, Font.BOLD, 50);
        graphics.setFont(font);

        //escrever uma frase na nova imagem

        graphics.drawString("TOPIZERA", 200, novaAltura-100);

        //escrever nova imagem num arquivo

        ImageIO.write(novaImagem, "png", new File(nomeArquivo));
    }
}
