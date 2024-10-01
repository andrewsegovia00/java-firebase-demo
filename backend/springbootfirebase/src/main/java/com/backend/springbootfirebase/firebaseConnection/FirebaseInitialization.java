package com.backend.springbootfirebase.firebase;
import org.springframework.stereotype.Service;

@Service
public class FirebaseInitialization{

    public void initialization() {

        FileInputStream serviceAccount = null;
        try {
            new FileInputStream("./serviceAccountKey.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();

        FirebaseApp.initializeApp(options);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}