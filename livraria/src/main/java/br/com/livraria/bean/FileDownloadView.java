package br.com.livraria.bean;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletResponse;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

@Named
@RequestScoped
@ManagedBean
//@SessionScoped
public class FileDownloadView {
    
    String path = "d:\\temp\\in.txt";
    
    /*public void download() throws IOException {
        String path = "d:\\temp\\in.txt";
        File file = new File(path);
        
        FacesContext facesContext = FacesContext.getCurrentInstance();
        
        HttpServletResponse response = (HttpServletResponse) facesContext
                .getExternalContext().getResponse();
        
        response.reset();
        response.setHeader("Content-Type", "application/octet-stream");
        response.setHeader("Content-Disposition",
                "attachment;filename=file.pdf");
        
        OutputStream responseOutputStream = response.getOutputStream();
        
        InputStream fileInputStream = new FileInputStream(file);
        
        byte[] bytesBuffer = new byte[2048];
        int bytesRead;
        while ((bytesRead = fileInputStream.read(bytesBuffer)) > 0) {
            responseOutputStream.write(bytesBuffer, 0, bytesRead);
        }
        
        responseOutputStream.flush();
        
        fileInputStream.close();
        responseOutputStream.close();
        
        facesContext.responseComplete();
        
    }*/
    
    public void download() throws IOException {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpServletResponse response = (HttpServletResponse) facesContext.getExternalContext().getResponse();

        response.reset();   // Algum filtro pode ter configurado alguns cabeçalhos no buffer de antemão. Queremos livrar-se deles, senão ele pode colidir.
        response.setHeader("Content-Type", "application/pdf");  // Define apenas o tipo de conteúdo, Utilize se necessário ServletContext#getMimeType() para detecção automática com base em nome de arquivo. 
        OutputStream responseOutputStream = response.getOutputStream();

        // Lê o conteúdo do PDF
        URL url = new URL(path);
        InputStream pdfInputStream = url.openStream();

        // Lê o conteúdo do PDF e grava para saída
        byte[] bytesBuffer = new byte[2048];
        int bytesRead;
        while ((bytesRead = pdfInputStream.read(bytesBuffer)) > 0) {
            responseOutputStream.write(bytesBuffer, 0, bytesRead);
        }    
        responseOutputStream.flush();

        // Fecha os streams
        pdfInputStream.close();
        responseOutputStream.close();         
        facesContext.responseComplete();         
    }
    
    /*
     * String path = "d:\\temp\\in.txt";
     * 
     * public StreamedContent FileDownloadView() { InputStream stream =
     * this.getClass().getResourceAsStream(path); file = new
     * DefaultStreamedContent(stream, "application/pdf", "file.pdf"); .builder()
     * .name("downloaded_boromir.jpg") .contentType("image/jpg") .stream(() ->
     * FacesContext.getCurrentInstance().getExternalContext()
     * .getResourceAsStream(path)) .build(); return file; }
     * 
     */
    
    private StreamedContent file;
    
    public void setFile(StreamedContent file) {
        this.file = file;
    }
    
    public StreamedContent getFile() throws FileNotFoundException {
        
        String caminhoWebInf = FacesContext.getCurrentInstance()
                .getExternalContext().getRealPath("/WEB-INF/");
        InputStream stream = new FileInputStream(path); // Caminho onde está
                                                        // salvo o arquivo.
        file = new DefaultStreamedContent(stream, "application/pdf",
                "edital.pdf");
        
        return file;
    }
}
