package com.company;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Tracy {

    private LocalHostServer net = null ;
    private ControllerServer server = null ;

    public Tracy(){
        this.init();
    }

    public void init(){
        this.net = new LocalHostServer();
        this.server = new ControllerServer();
        if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
            try {
                Desktop.getDesktop().browse(new URI("http://localhost:1402"));
            } catch (IOException e) {
                System.err.println(e);
            } catch (URISyntaxException e) {
                System.err.println(e);
            }
        }
    }


    public Model Model(){
        return this.server.Model();
    }

}
