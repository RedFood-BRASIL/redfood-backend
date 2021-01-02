package com.github.vicenthy.endpoints.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

import io.quarkus.security.Authenticated;

@Path("/upload")
@Authenticated
public class UploadFile {

    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.TEXT_PLAIN)
    public Response uploadFotos( @MultipartForm MultipartBody data, String fileName) throws IOException {
        String basedir = "/tmp/uploads";
        java.nio.file.Path directory = Files.createDirectories(Paths.get(basedir + fileName));
        if (directory != null){
            File file = new File(directory.toFile().getAbsolutePath() + "/" + data.fileName);
            try (OutputStream os = new FileOutputStream(file)){
                os.write(data.file.readAllBytes());
            }
        }
        return Response.ok().build();
    }
}
