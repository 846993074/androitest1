package com.example.myapplicationdnk1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplicationdnk1.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'myapplicationdnk1' library on application startup.
    static {
        System.loadLibrary("myapplicationdnk1");
    }
    Button add;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Example of a call to a native method
        TextView tv = binding.sampleText;
        tv.setText(stringFromJNI());

        add=findViewById(R.id.button);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"和为："+addFromJNI(5,6),Toast.LENGTH_LONG).show();

            }
        });
    }

    /**
     * A native method that is implemented by the 'myapplicationdnk1' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
    public native int  addFromJNI(int a ,int b);

    public int add(int a,int b)
    {
        return a+b;
    }

}