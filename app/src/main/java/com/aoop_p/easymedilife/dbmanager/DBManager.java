package com.aoop_p.easymedilife.dbmanager;

import android.util.Log;
import android.widget.ArrayAdapter;

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
import java.util.ArrayList;

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
    public ArrayList<String> getdistrict()
    {
        String line;
        ArrayList<String> dist = new ArrayList<>();
        String host = "https://firstsalebd.com/api/getdistrict.php", user = "firstsal_EasyMediLife", pass = "EasyMediLife";
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
                dist.add(line);
                Log.i("errormes", line);
            }
            read.close();
            in.close();

        }
        catch (Exception e) {
            // TODO: handle exception
        }
        return dist;

    }

    public String addDistrctAndsubdis(String dist, String subdis)
    {
        String line;
        StringBuilder fullline = new StringBuilder();
        String host = "https://firstsalebd.com/api/ad_dis_subdis.php", user = "firstsal_EasyMediLife", pass = "EasyMediLife";
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
                    +"&&"+URLEncoder.encode("dist", "UTF-8")+"="+URLEncoder.encode(dist, "UTF-8")
                    +"&&"+URLEncoder.encode("sub_dis", "UTF-8")+"="+URLEncoder.encode(subdis, "UTF-8");

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
    public ArrayList<String> getsubDist(String dist)
    {
        String line;
        ArrayList<String> fullline = new ArrayList<>();
        String host = "https://firstsalebd.com/api/getsubdistrict.php", user = "firstsal_EasyMediLife", pass = "EasyMediLife";
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
                fullline.add(line);
                Log.i("errormes", line);
            }
            read.close();
            in.close();
        }
        catch (Exception e) {
            Log.i("errormes", "connection failed");
        }

        return fullline;
    }
    public boolean useradmin(String email, String password)
    {
        String line;
        StringBuilder fullline = new StringBuilder();
        String host = "https://firstsalebd.com/api/user_admin.php", user = "firstsal_EasyMediLife", pass = "EasyMediLife";
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
    public void update_user_address(String email, String password, String dist, String subdis, String address)
    {
        String line;
        StringBuilder fullline = new StringBuilder();
        String host = "https://firstsalebd.com/api/update_user_address.php", user = "firstsal_EasyMediLife", pass = "EasyMediLife";
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
                    +"&&"+URLEncoder.encode("password", "UTF-8")+"="+URLEncoder.encode(password, "UTF-8")
                    +"&&"+URLEncoder.encode("dist", "UTF-8")+"="+URLEncoder.encode(dist, "UTF-8")
                    +"&&"+URLEncoder.encode("sub_dist", "UTF-8")+"="+URLEncoder.encode(subdis, "UTF-8")
                    +"&&"+URLEncoder.encode("address", "UTF-8")+"="+URLEncoder.encode(address, "UTF-8");


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

    }

    public boolean userLoginwithid(String id, String password)
    {
        String line;
        StringBuilder fullline = new StringBuilder();
        String host = "https://firstsalebd.com/api/loginwithid.php", user = "firstsal_EasyMediLife", pass = "EasyMediLife";
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
                    +"&&"+URLEncoder.encode("id", "UTF-8")+"="+URLEncoder.encode(id, "UTF-8")
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
    public String addHospital(String dist, String subdist, String hospital)
    {
        String line;
        String fullline = "";
        String host = "https://firstsalebd.com/api/addhospital.php", user = "firstsal_EasyMediLife", pass = "EasyMediLife";
        try {

            url = new URL(host);

            http = (HttpURLConnection) url.openConnection();
            http.setRequestMethod("POST");
            http.setDoInput(true);
            http.setDoOutput(true);

            out = http.getOutputStream();


            write = new BufferedWriter(new OutputStreamWriter(out, StandardCharsets.UTF_8));
            String data = URLEncoder.encode("user", "UTF-8") + "=" + URLEncoder.encode(user, "UTF-8")
                    + "&&" + URLEncoder.encode("pass", "UTF-8") + "=" + URLEncoder.encode(pass, "UTF-8")
                    + "&&" + URLEncoder.encode("district", "UTF-8") + "=" + URLEncoder.encode(dist, "UTF-8")
                    + "&&" + URLEncoder.encode("subdist", "UTF-8") + "=" + URLEncoder.encode(subdist, "UTF-8")
                    + "&&" + URLEncoder.encode("hospital", "UTF-8") + "=" + URLEncoder.encode(hospital, "UTF-8");

            write.write(data);
            write.flush();
            write.close();
            out.close();
            in = http.getInputStream();
            read = new BufferedReader(new InputStreamReader(in, StandardCharsets.ISO_8859_1));

            while ((line = read.readLine()) != null) {
                fullline+=line;
            }
            read.close();
            in.close();
        }
        catch(Exception e)
        {

        }
        return fullline;
    }

    public void addsymtomswithdescreption(String symptom, String descreption)
    {
        String line;
        StringBuilder fullline = new StringBuilder();
        String host = "https://firstsalebd.com/api/addsymptom.php", user = "firstsal_EasyMediLife", pass = "EasyMediLife";
        try {

            url = new URL(host);

            http = (HttpURLConnection) url.openConnection();
            http.setRequestMethod("POST");
            http.setDoInput(true);
            http.setDoOutput(true);

            out = http.getOutputStream();


            write = new BufferedWriter(new OutputStreamWriter(out, StandardCharsets.UTF_8));
            String data = URLEncoder.encode("user", "UTF-8") + "=" + URLEncoder.encode(user, "UTF-8")
                    + "&&" + URLEncoder.encode("pass", "UTF-8") + "=" + URLEncoder.encode(pass, "UTF-8")
                    + "&&" + URLEncoder.encode("symptom", "UTF-8") + "=" + URLEncoder.encode(symptom, "UTF-8")
                    + "&&" + URLEncoder.encode("description", "UTF-8") + "=" + URLEncoder.encode(descreption, "UTF-8");

            write.write(data);
            write.flush();
            write.close();
            out.close();
            in = http.getInputStream();
            read = new BufferedReader(new InputStreamReader(in, StandardCharsets.ISO_8859_1));

            while ((line = read.readLine()) != null) {
                fullline.append(line);
            }
            read.close();
            in.close();
        }
        catch(Exception e)
        {

        }
    }
    public void addsymptodoctor(String doctor, String symptoms, String description)
    {
        String line;
        StringBuilder fullline = new StringBuilder();
        String host = "https://firstsalebd.com/api/addsymtodoc.php", user = "firstsal_EasyMediLife", pass = "EasyMediLife";
        try {

            url = new URL(host);

            http = (HttpURLConnection) url.openConnection();
            http.setRequestMethod("POST");
            http.setDoInput(true);
            http.setDoOutput(true);

            out = http.getOutputStream();


            write = new BufferedWriter(new OutputStreamWriter(out, StandardCharsets.UTF_8));
            String data = URLEncoder.encode("user", "UTF-8") + "=" + URLEncoder.encode(user, "UTF-8")
                    + "&&" + URLEncoder.encode("pass", "UTF-8") + "=" + URLEncoder.encode(pass, "UTF-8")
                    + "&&" + URLEncoder.encode("doctor", "UTF-8") + "=" + URLEncoder.encode(doctor, "UTF-8")
                    + "&&" + URLEncoder.encode("symptom", "UTF-8") + "=" + URLEncoder.encode(symptoms, "UTF-8")
                    + "&&" + URLEncoder.encode("description", "UTF-8") + "=" + URLEncoder.encode(description, "UTF-8");

            write.write(data);
            write.flush();
            write.close();
            out.close();
            in = http.getInputStream();
            read = new BufferedReader(new InputStreamReader(in, StandardCharsets.ISO_8859_1));

            while ((line = read.readLine()) != null) {
                fullline.append(line);
            }
            read.close();
            in.close();
        }
        catch(Exception e)
        {

        }
    }
    public ArrayList<String> gethospital(String district, String subdist)
    {
        String line;
        ArrayList<String> fulline = new ArrayList<>();
        String host = "https://firstsalebd.com/api/gethospitals.php", user = "firstsal_EasyMediLife", pass = "EasyMediLife";
        try {

            url = new URL(host);

            http = (HttpURLConnection) url.openConnection();
            http.setRequestMethod("POST");
            http.setDoInput(true);
            http.setDoOutput(true);

            out = http.getOutputStream();


            write = new BufferedWriter(new OutputStreamWriter(out, StandardCharsets.UTF_8));
            String data = URLEncoder.encode("user", "UTF-8") + "=" + URLEncoder.encode(user, "UTF-8")
                    + "&&" + URLEncoder.encode("pass", "UTF-8") + "=" + URLEncoder.encode(pass, "UTF-8")
                    + "&&" + URLEncoder.encode("district", "UTF-8") + "=" + URLEncoder.encode(district, "UTF-8")
                    + "&&" + URLEncoder.encode("subdist", "UTF-8") + "=" + URLEncoder.encode(subdist, "UTF-8");

            write.write(data);
            write.flush();
            write.close();
            out.close();
            in = http.getInputStream();
            read = new BufferedReader(new InputStreamReader(in, StandardCharsets.ISO_8859_1));

            while ((line = read.readLine()) != null) {
                fulline.add(line);
            }
            read.close();
            in.close();
        }
        catch(Exception e)
        {

        }
        return  fulline;
    }

    public ArrayList<String> getdoctoronlocation(String dist, String subdist)
    {
        String line;
        ArrayList<String> fulline = new ArrayList<>();
        String host = "https://firstsalebd.com/api/getdoctor.php", user = "firstsal_EasyMediLife", pass = "EasyMediLife";
        try {

            url = new URL(host);

            http = (HttpURLConnection) url.openConnection();
            http.setRequestMethod("POST");
            http.setDoInput(true);
            http.setDoOutput(true);

            out = http.getOutputStream();


            write = new BufferedWriter(new OutputStreamWriter(out, StandardCharsets.UTF_8));
            String data = URLEncoder.encode("user", "UTF-8") + "=" + URLEncoder.encode(user, "UTF-8")
                    + "&&" + URLEncoder.encode("pass", "UTF-8") + "=" + URLEncoder.encode(pass, "UTF-8")
                    + "&&" + URLEncoder.encode("district", "UTF-8") + "=" + URLEncoder.encode(dist, "UTF-8")
                    + "&&" + URLEncoder.encode("subdist", "UTF-8") + "=" + URLEncoder.encode(subdist, "UTF-8");

            write.write(data);
            write.flush();
            write.close();
            out.close();
            in = http.getInputStream();
            read = new BufferedReader(new InputStreamReader(in, StandardCharsets.ISO_8859_1));

            while ((line = read.readLine()) != null) {
                fulline.add(line);
            }
            read.close();
            in.close();
        }
        catch(Exception e)
        {

        }
        return  fulline;
    }
    public String adDoctor(String doctor, String hospital)
    {
        String line;
        StringBuilder fullline = new StringBuilder();
        String host = "https://firstsalebd.com/api/addspecialist.php", user = "firstsal_EasyMediLife", pass = "EasyMediLife";
        try {

            url = new URL(host);

            http = (HttpURLConnection) url.openConnection();
            http.setRequestMethod("POST");
            http.setDoInput(true);
            http.setDoOutput(true);

            out = http.getOutputStream();


            write = new BufferedWriter(new OutputStreamWriter(out, StandardCharsets.UTF_8));
            String data = URLEncoder.encode("user", "UTF-8") + "=" + URLEncoder.encode(user, "UTF-8")
                    + "&&" + URLEncoder.encode("pass", "UTF-8") + "=" + URLEncoder.encode(pass, "UTF-8")
                    + "&&" + URLEncoder.encode("doctor", "UTF-8") + "=" + URLEncoder.encode(doctor, "UTF-8")
                    + "&&" + URLEncoder.encode("hospital", "UTF-8") + "=" + URLEncoder.encode(hospital, "UTF-8");

            write.write(data);
            write.flush();
            write.close();
            out.close();
            in = http.getInputStream();
            read = new BufferedReader(new InputStreamReader(in, StandardCharsets.ISO_8859_1));

            while ((line = read.readLine()) != null) {
                fullline.append(line);
            }
            read.close();
            in.close();
        }
        catch(Exception e)
        {

        }
        return fullline.toString();
    }


}
