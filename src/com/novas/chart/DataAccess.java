package com.novas.chart;

import javax.imageio.IIOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by novas on 2016/3/23.
 */
public class DataAccess extends HttpServlet {
    HashMap<String,String[]> map=new HashMap<String, String[]>();
    public String[] readData(File file)
    {
        ArrayList<String> arrayList=new ArrayList<String>();
        BufferedReader bufferedReader=null;
        try {
            bufferedReader=new BufferedReader(new FileReader(file));
            String line=bufferedReader.readLine();
            while (line!=null)
            {
                String[] args=line.split(",");
                if(args.length<1)
                {
                    System.out.println("line="+line);
                }
              //  System.out.println("length="+args[0]);
                arrayList.add(args[0]);
                line=bufferedReader.readLine();
            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        String[] data=new String[arrayList.size()];
        arrayList.toArray(data);
        return data;
    }
    @Override
    public void init() throws ServletException {
        super.init();
System.out.println("init");
        File f=new File("../text");
     //   System.out.println(f.getAbsolutePath());
        File[] files=f.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                if(pathname.getName().endsWith(".csv"))
                    return true;
                return false;
            }
        });
        for(int i=0;i<files.length;i++)
        {
          //  System.out.println(files[i].getName());
            String name=files[i].getName();
            name=name.substring(0,name.indexOf("."));
            map.put(name,readData(files[i]));
        }

    }

    public DataAccess() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("in do get");
        String dataselect=req.getParameter("dataselect");
        System.out.println("dataselect="+dataselect);
        resp.setContentType("text/html;charset=GBK");
        PrintWriter out = resp.getWriter();
        out.print(dataselect);
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("dataaccess dopost");
        resp.setContentType("text/html;charset=GBK");
        PrintWriter out = resp.getWriter();
        out.print("fafafadfafasdfa");
        out.close();
    }

}