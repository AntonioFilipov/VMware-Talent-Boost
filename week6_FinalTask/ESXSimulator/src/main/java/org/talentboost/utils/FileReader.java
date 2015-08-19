package org.talentboost.utils;

import java.io.File;
import java.io.InputStream;
import java.net.URL;

public class FileReader {
    private InputStream input;
    private URL url;
    
    public FileReader(InputStream input, URL file){
        this.setInput(input);
        this.setURL(url);
    }

    public InputStream getInput() {
        return input;
    }

    public void setInput(InputStream input) {
        this.input = input;
    }

    public URL getURL() {
        return url;
    }

    public void setURL(URL url) {
        this.url = url;
    }
}
