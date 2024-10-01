package com.backend.springbootfirebase.service;

import com.backend.springbootfirebase.entity.Product;
import org.springframework.stereotype.Service;

@Service
pubblic class ProductServices {

    public static final String COLLECTION_NAME = "products";
    public String saveProduct(Product product) throws ExecutionException, InterruptException {
        Firestore dbFirestore = FirestoreClient.getFirestore();

        ApiFuture <WriteResult> collectionApiFuture = dbFirestore.collection(COLLECTION_NAME).document(product.getName()).set(product);

        return collectionApiFuture.get().getUpdateTime().toString();

    }
}
