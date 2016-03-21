package com.scurrae.chris.quickpix;

import android.content.Intent;
import android.graphics.Camera;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private ImageView imageView;
    private DatabaseHandler db;
    static final int CAM_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button)findViewById(R.id.open_cam);
        imageView = (ImageView)findViewById(R.id.grid);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent to open camera app
                Intent camera_intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                // Accessing the image file
                File file = getFile();
                // Returning the image from camera
                camera_intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));
                // Begin camera activity
                startActivityForResult(camera_intent, CAM_REQUEST);

            }
        });
    }
    private File getFile(){
        // Instanciate file
        File folder = new File("sdcard/camera_app");
        boolean success = false;
        if(!folder.exists()){
            // Create folder if it doesn't exist
            success = folder.mkdir();
        }
        if(!success){
            Log.d("MAIN", "Folder not Created");
        } else {
            Log.d("MAIN", "Folder  Created");
        }
        // Create image file
        File image_file = new File(folder, "cam_image.jpg");

        return image_file;

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        String path = "sdcard/camera_app/cam_image.jpg";
        imageView.setImageDrawable(Drawable.createFromPath(path));

    }
}
