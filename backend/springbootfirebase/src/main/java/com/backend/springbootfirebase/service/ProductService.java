package com.backend.springbootfirebase.service;

import com.backend.springbootfirebase.entity.Product;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.lang.InterruptedException;  // Ensure to import InterruptedException

@Service
public class ProductService {

    public static final String COLLECTION_NAME = "products";

    public String saveProduct(Product product) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();

        ApiFuture<WriteResult> collectionApiFuture = dbFirestore.collection(COLLECTION_NAME)
                .document(product.getName()).set(product);
        return collectionApiFuture.get().getUpdateTime().toString();
    }


    public Product getProductDetails(String name) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();

        DocumentReference documentReference = dbFirestore.collection(COLLECTION_NAME).document(name);

        ApiFuture <DocumentSnapshot> future = documentReference.get();

        DocumentSnapshot document = future.get();

        Product product = null;
        if(document.exists()) {
            product = document.toObject(Product.class);
            return product;
        } else {
            return null;
        }
    }

    public List<Product> getAllProductDetails() throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();

        Iterable<DocumentReference> documentReference = dbFirestore.collection(COLLECTION_NAME).listDocuments();

        Iterator<DocumentReference> iterator = documentReference.iterator();

        List<Product> productList = new ArrayList<>();
        Product product = null;

        while(iterator.hasNext()) {
            DocumentReference documentReferenceIterator = iterator.next();

            ApiFuture<DocumentSnapshot> future = documentReferenceIterator.get();

            DocumentSnapshot document = future.get();

            product = document.toObject(Product.class);
            productList.add(product);
        }
        return productList;
    }

    public String updateProduct(String name, Product updatedProduct) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();

        // Retrieve the existing document
        DocumentReference documentReference = dbFirestore.collection(COLLECTION_NAME).document(name);
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        DocumentSnapshot document = future.get();

        if (!document.exists()) {
            return "Product not found!";
        }

        Product existingProduct = document.toObject(Product.class);

        if (updatedProduct.getName() != null) {
            existingProduct.setName(updatedProduct.getName());
        }
        if (updatedProduct.getNumber() != null) {
            existingProduct.setNumber(updatedProduct.getNumber());
        }

        ApiFuture<WriteResult> collectionApiFuture = documentReference.set(existingProduct);
        return collectionApiFuture.get().getUpdateTime().toString();
    }


    public String deleteProduct(String name) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();

        ApiFuture<WriteResult> collectionApiFuture = dbFirestore.collection(COLLECTION_NAME).document(name).delete();
        return "The " + name + " product has been deleted";
    }

}
