package com.backend.springbootfirebase.firebase;
import org.springframework.stereotype.Service;

@Service
public class FirebaseInitialization{

    public void initialization() {
        FileInputStream serviceAccount =
                new FileInputStream("path/to/serviceAccountKey.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();

        FirebaseApp.initializeApp(options);
    }

}