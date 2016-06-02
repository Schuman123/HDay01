package bogo.client.com;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



public class BogoclientActivity extends Activity {
    private String SERVER_HOST_IP;

    private int SERVER_HOST_PORT;
    //控件
    private Button btnConnect;
    private Button btnfresh;

    private EditText controlip;
    private EditText controlport;
    //控件
    private TextView edittemperature;
    private TextView editshidu;
    private TextView editguangzhao;
    private Socket socket;
    //输出流
    private OutputStream output;
    //输入流
    private InputStream intput;



    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);//显示布局
        //初始化控件
        initView();
        //设置connnect按钮的监听事件  匿名内部类
        btnConnect.setOnClickListener(new Button.OnClickListener()//socket连接
        {
            @Override
            public void onClick(View v) {
                initClientSocket();
            }
        });
        //设置fresh按钮的监听事件  匿名内部类
        btnfresh.setOnClickListener(new Button.OnClickListener()//按钮信息
        {
            @Override
            public void onClick(View v)     //刷新
            {
                String resultdate;
                //主从式，先发数据到服务器端，然后接收，完成一次刷新
                //@Android|温度值|湿度值|PH值|光强度|---
                sendMessage("@Android,getdate,");
                resultdate = receiveMessage();
                String[] datespiltStrings = resultdate.split(",");//按照","分割字符串
                edittemperature.setText("温度：" + datespiltStrings[1] + "C");//@Android
                editshidu.setText("湿度：" + datespiltStrings[2] + "%");//getdate
                editguangzhao.setText("红外：" + datespiltStrings[3]);


            }
        });
    }

    public void initView()
    //初始化控件
    {
        btnConnect = (Button) findViewById(R.id.btnConnect);    //连接
        btnfresh = (Button) findViewById(R.id.btnfresh);        //更新
        controlip = (EditText) findViewById(R.id.ip);            //ip
        controlport = (EditText) findViewById(R.id.port);          //port

        edittemperature = (TextView) findViewById(R.id.temperature);
        editshidu = (TextView) findViewById(R.id.shidu);
        editguangzhao = (TextView) findViewById(R.id.gz);

        edittemperature.setText("温度：0 C");
        editshidu.setText("湿度：0 %");
        editguangzhao.setText("红外检测:  0  ");
        btnfresh.setEnabled(false);

    }

    public void closeSocket() {
        try {
            output.close();
            socket.close();
        } catch (IOException e) {
            handleException(e, "close exception: ");
        }
    }

    //初始化客户端socket程序
    private void initClientSocket() {
        try {
            SERVER_HOST_IP = controlip.getText().toString();//将输入的文本转换成字符串
            SERVER_HOST_PORT = Integer.parseInt(controlport.getText().toString());//将字符串转换成int值
            socket = new Socket(SERVER_HOST_IP, SERVER_HOST_PORT);

            //定义输入输出流
            intput = socket.getInputStream();//输入流
            output = socket.getOutputStream();//输出流

            btnConnect.setEnabled(false);
            controlip.setEnabled(false);
            controlport.setEnabled(false);

            btnfresh.setEnabled(true);

        } catch (UnknownHostException e) {
            handleException(e, "unknown host exception: " + e.toString());
        } catch (IOException e) {
            handleException(e, "io exception: " + e.toString());
        }
    }

    private void sendMessage(String msg)    //发送数据，数据为msg
    {

        try {
            byte[] send = msg.getBytes();//将字符串转换成字节数组
            output.write(send);//写出
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private String receiveMessage()    //接收数据,返回值为接收的数值
    {
        String wwei = "@Android,22,88,13,14";
        try {
            byte[] buffer = new byte[1024];
            int bytes;
            bytes = intput.read(buffer);//读入
            wwei = new String(buffer);//将字节数组转换成字符串
            return wwei;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return wwei;
    }
    public void toastText(String message) {
        //Toast弹窗
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public void handleException(Exception e, String prefix) {
        e.printStackTrace();
        toastText(prefix + e.toString());
    }


}