package com.backend.springbootfirebase.firebaseConnection;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

@Service
public class FirebaseInitialization {

    @PostConstruct
    public void initialization() {
        FileInputStream serviceAccount = null;
        try {
//            serviceAccount = new FileInputStream("springbootfirebase/src/main/resources/serviceAccountKey.json");

            String jsonString = "{\n" +
                    "  \"type\": \"service_account\",\n" +
                    "  \"project_id\": \"firstprojectback\",\n" +
                    "  \"private_key_id\": \"05a10d8e38dc96ba02ce682425011d73cd93421b\",\n" +
                    "  \"private_key\": \"-----BEGIN PRIVATE KEY-----\\nMIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQC295+K6noD3ADF\\n/ag4KtbzBUN01oRw69DNYirYS/jIRFMzVL7xZp5KYpeSmoStPNNmsjt4Ma5gxH0a\\nbeksOfYnvMqx65w476ilC42tL4nhL49yCRlDmpiVlfDFyIzvvWZK7mCdp45shWo9\\nPWXpxTS4k9GdKc+xPyNY3EN1V8kSrchivxdxcjWKCD8v9FK3CMudq8cW4X4OeMD/\\nMmsAcUJTqaSF3DyOdRSoje3YSnYAITlvk+yy5+ZjhaaJPztLhDVUPW2PmFHr64uJ\\n8RaHJGIFR5UzaGLBHPjbKlcvG7FLqF75ySzRCs3mDOAe8hwYRjOLkpfswkNYMCO/\\nZvqc2/uZAgMBAAECggEABXJjtn/6d+jxwPMnMdzcn0l106GbOb1bbvHQMrY4RsX5\\n8BpCwO78IVzEBGJDNuELrg/6Qz6/YTQYQVQqT9293Tr6kcdg1DUWQSuR4Sj8Is8G\\npy9sKB4PEszu6QRqZayuweZMzASz8bkbC42rXgU355LG97XJ8A3gIIIWJAUkAEFN\\nRZdZOzz5kC9sFy68ndrTIEyuz5Sq4r1Nzv08gJbIbWqimjU7qeBC0hxkiBWPbDoN\\nY8BqxN8K9N4WGp+f+XYcr9Wtqk/xwMnzqvt+EAljTiY+bWD1S/GpZQRI7f+XD/WU\\neAc+CjmQXcKhYmBSyVueyQwvbxHUD955xyrlt39IzQKBgQDcJnNBWM2ZB2gQNeKK\\nw74M1jjajw2PuaGpcmLxJm7UmhWmDDESjiDOGnM2U5mbHz+PiZuLoLCc7WKp/1ks\\nn7Tx6A7d8CrApQp/6ufiq3wt9bbcSbADd/ZT28/jYJCATkq+EP+WNUU1RG5c1Nz9\\nzamvFDubzgAGL/3BjMJkrPa/FwKBgQDUwxqF2Nh3ni7HG0oZOdPd/e2YYyf6eyFJ\\norepX8+ldwtECihcHGtHKZDbaJlNEDAMmPj3iWI3fy9TDBlqP2o1Y7x4RIwhx4Id\\n//uM4iieJJ5smHKbyeDLOSE/8Jdi6RMK2d3q6xPalv3Be/uClNNYrxwjME6fFTs4\\npkkk6M9IzwKBgQCrBbPDsBkIKJjO/w1ef3HExyajoz4FyU+tMw9qB1FSF+F5fT8i\\nCwexFRsruQY7W6sk9uG/NrX9MuzS42uDHw6SXpQuFcUgoxXlCbfafx2ZFqlXuGbk\\nSu0xeDGnkfyvsCKgRNRI/FknaGHT/AkxofOP70ffYcjjBaU8Fv1s+HE3QQKBgGL0\\nb1SLW3qe/qCqR5dd9vVL0gLLM1/jfsLxxDwpjLknmfzGQKk+qoKJiY8SoiJeggqJ\\n51mx8xVeuRMGEJgC8JHuVk0VjJt1YEY1tbh7w2pyG6DkcoGUrlG2u4kyjCZ7wtiM\\nJhPJzA0hptojoQHF2Fpp70tKf3ar+ERLyr847JevAoGBAKw7Wx6lAu7fC994/dZk\\nMLxRPNE8ZYwggWRNFQqPh9CfA4DyAi7kH0ZGY2DnuU0Ygt3G5BHscKDIEZSUeFdU\\n55HXS37TnkLvU+ScDC+XYVOKlSlTlCUSwBKW/QylWKzq5pZ4iMuJeRzYYZeifl+l\\nVR9dmpEVFqG4M/MKD1QL48XG\\n-----END PRIVATE KEY-----\\n\",\n" +
                    "  \"client_email\": \"firebase-adminsdk-mk7nx@firstprojectback.iam.gserviceaccount.com\",\n" +
                    "  \"client_id\": \"103153602851706165867\",\n" +
                    "  \"auth_uri\": \"https://accounts.google.com/o/oauth2/auth\",\n" +
                    "  \"token_uri\": \"https://oauth2.googleapis.com/token\",\n" +
                    "  \"auth_provider_x509_cert_url\": \"https://www.googleapis.com/oauth2/v1/certs\",\n" +
                    "  \"client_x509_cert_url\": \"https://www.googleapis.com/robot/v1/metadata/x509/firebase-adminsdk-mk7nx%40firstprojectback.iam.gserviceaccount.com\",\n" +
                    "  \"universe_domain\": \"googleapis.com\"\n" +
                    "}\n";
            InputStream stream = new ByteArrayInputStream(jsonString.getBytes());

            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(stream))
                    .build();

            FirebaseApp.initializeApp(options);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (serviceAccount != null) {
                    serviceAccount.close();  // Ensure the stream is closed
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
