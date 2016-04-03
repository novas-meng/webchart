package com.novas.chart;

import javax.imageio.IIOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;

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
        String type=req.getParameter("type");
        String[] args=map.get(dataselect);
        resp.setContentType("text/html;charset=GBK");
        PrintWriter out = resp.getWriter();
        if(type.equals("year"))
        {
            ArrayList<String> yearlist=new ArrayList<String>();
            for(int i=0;i<args.length;i++)
            {
                String[] temps=args[i].split("/");
                String temp=temps[0];
                if(!yearlist.contains(temp))
                yearlist.add(temp);
            }
            StringBuffer sb=new StringBuffer();
            Iterator<String> iterator=yearlist.iterator();
            while (iterator.hasNext())
            {
                sb.append(" ").append(iterator.next());
            }
            out.print(sb.toString().substring(1));
            out.close();
        }
        else if (type.equals("month"))
        {
            String year=req.getParameter("year");
            ArrayList<String> monthlist=new ArrayList<String>();
            for(int i=0;i<args.length;i++)
            {
                String[] temps=args[i].split("/");
                String temp=temps[0]+"/"+temps[1];
                if(!monthlist.contains(temp)&&temps[0].equals(year))
                    monthlist.add(temp);
            }
            StringBuffer sb=new StringBuffer();
            Iterator<String> iterator=monthlist.iterator();
            while (iterator.hasNext())
            {
                sb.append(" ").append(iterator.next().split("/")[1]);
            }
            out.print(sb.toString().substring(1));
            out.close();
        }
        else if(type.equals("day"))
        {
            String year=req.getParameter("year");
            String month=req.getParameter("month");
            ArrayList<String> monthlist=new ArrayList<String>();
            for(int i=0;i<args.length;i++)
            {
                String[] temps=args[i].split("/");
                if(temps[0].equals(year)&&temps[1].equals(month))
                    monthlist.add(args[i]);
            }
            StringBuffer sb=new StringBuffer();
            Iterator<String> iterator=monthlist.iterator();
            while (iterator.hasNext())
            {
                sb.append(" ").append(iterator.next().split("/")[2]);
            }
            out.print(sb.toString().substring(1));
            out.close();
        }
        System.out.println("dataselect="+dataselect);
        System.out.println(req.getParameter("type"));
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