package com.aoop_p.easymedilife.dbmanager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class DBManager {
    private URL url;
    private HttpURLConnection http;
    private OutputStream out = null;
    private BufferedWriter write;
    private InputStream in;
    private BufferedReader read;

    public String connect()
    {
        String line;
        StringBuilder fullline = new StringBuilder();
        String host = "https://firstsalebd.com/api/connect.php", user = "firstsal_EasyMediLife", pass = "EasyMediLife";
        try
        {

            url = new URL(host);

            http = (HttpURLConnection) url.openConnection();
            http.setRequestMethod("POST");
            http.setDoInput(true);
            http.setDoOutput(true);

            out = http.getOutputStream();


            write = new BufferedWriter(new OutputStreamWriter(out, StandardCharsets.UTF_8));
            String data = URLEncoder.encode("user", "UTF-8")+"="+URLEncoder.encode(user, "UTF-8")
                    +"&&"+URLEncoder.encode("pass", "UTF-8")+"="+URLEncoder.encode(pass, "UTF-8");

            write.write(data);
            write.flush();
            write.close();
            out.close();
            in = http.getInputStream();
            read = new BufferedReader(new InputStreamReader(in, StandardCharsets.ISO_8859_1));

            while((line = read.readLine()) != null)
            {
                fullline.append(line);
            }
            read.close();
            in.close();

        }
        catch (Exception e) {
            // TODO: handle exception
        }

        return fullline.toString();

    }
    public boolean userLogin(String email, String password)
    {
        String line;
        StringBuilder fullline = new StringBuilder();
        String host = "https://firstsalebd.com/api/login.php", user = "firstsal_EasyMediLife", pass = "EasyMediLife";
        try
        {

            url = new URL(host);

            http = (HttpURLConnection) url.openConnection();
            http.setRequestMethod("POST");
            http.setDoInput(true);
            http.setDoOutput(true);

            out = http.getOutputStream();


            write = new BufferedWriter(new OutputStreamWriter(out, StandardCharsets.UTF_8));
            String data = URLEncoder.encode("user", "UTF-8")+"="+URLEncoder.encode(user, "UTF-8")
                    +"&&"+URLEncoder.encode("pass", "UTF-8")+"="+URLEncoder.encode(pass, "UTF-8")
                    +"&&"+URLEncoder.encode("email", "UTF-8")+"="+URLEncoder.encode(email, "UTF-8")
                    +"&&"+URLEncoder.encode("password", "UTF-8")+"="+URLEncoder.encode(password, "UTF-8");

            write.write(data);
            write.flush();
            write.close();
            out.close();
            in = http.getInputStream();
            read = new BufferedReader(new InputStreamReader(in, StandardCharsets.ISO_8859_1));

            while((line = read.readLine()) != null)
            {
                fullline.append(line);
            }
            read.close();
            in.close();
        }
        catch (Exception e) {
            // TODO: handle exception
        }

        return fullline.toString().equalsIgnoreCase("true");
    }

    public boolean register(String email, String name, String phone, String password)
    {
        String line;
        StringBuilder fullline = new StringBuilder();
        String host = "https://firstsalebd.com/api/register.php", user = "firstsal_EasyMediLife", pass = "EasyMediLife";
        try
        {

            url = new URL(host);

            http = (HttpURLConnection) url.openConnection();
            http.setRequestMethod("POST");
            http.setDoInput(true);
            http.setDoOutput(true);

            out = http.getOutputStream();


            write = new BufferedWriter(new OutputStreamWriter(out, StandardCharsets.UTF_8));
            String data = URLEncoder.encode("user", "UTF-8")+"="+URLEncoder.encode(user, "UTF-8")
                    +"&&"+URLEncoder.encode("pass", "UTF-8")+"="+URLEncoder.encode(pass, "UTF-8")
                    +"&&"+URLEncoder.encode("email", "UTF-8")+"="+URLEncoder.encode(email, "UTF-8")
                    +"&&"+URLEncoder.encode("name", "UTF-8")+"="+URLEncoder.encode(name, "UTF-8")
                    +"&&"+URLEncoder.encode("phone", "UTF-8")+"="+URLEncoder.encode(phone, "UTF-8")
                    +"&&"+URLEncoder.encode("pass", "UTF-8")+"="+URLEncoder.encode(password, "UTF-8");

            write.write(data);
            write.flush();
            write.close();
            out.close();
            in = http.getInputStream();
            read = new BufferedReader(new InputStreamReader(in, StandardCharsets.ISO_8859_1));

            while((line = read.readLine()) != null)
            {
                fullline.append(line);
            }
            read.close();
            in.close();
        }
        catch (Exception e) {
            // TODO: handle exception
        }

        return fullline.toString().equalsIgnoreCase("true");
    }
    public String addDistrct(String dist)
    {
        String line;
        StringBuilder fullline = new StringBuilder();
        String host = "https://firstsalebd.com/api/add_dist.php", user = "firstsal_EasyMediLife", pass = "EasyMediLife";
        try
        {

            url = new URL(host);

            http = (HttpURLConnection) url.openConnection();
            http.setRequestMethod("POST");
            http.setDoInput(true);
            http.setDoOutput(true);

            out = http.getOutputStream();


            write = new BufferedWriter(new OutputStreamWriter(out, StandardCharsets.UTF_8));
            String data = URLEncoder.encode("user", "UTF-8")+"="+URLEncoder.encode(user, "UTF-8")
                    +"&&"+URLEncoder.encode("pass", "UTF-8")+"="+URLEncoder.encode(pass, "UTF-8")
                    +"&&"+URLEncoder.encode("dist", "UTF-8")+"="+URLEncoder.encode(dist, "UTF-8");

            write.write(data);
            write.flush();
            write.close();
            out.close();
            in = http.getInputStream();
            read = new BufferedReader(new InputStreamReader(in, StandardCharsets.ISO_8859_1));

            while((line = read.readLine()) != null)
            {
                fullline.append(line);
            }
            read.close();
            in.close();
        }
        catch (Exception e) {
            // TODO: handle exception
        }

        return fullline.toString();
    }

}
