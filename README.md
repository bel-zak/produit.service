 README.md

# Microservice de Gestion de Produits

## Description

Ce projet est un microservice de gestion de l'inventaire des produits développé avec Spring Boot. Il expose une API REST permettant d'ajouter, de supprimer, de mettre à jour et de récupérer des informations sur les produits.

## Prérequis

- **Java 17** ou version supérieure
- **Maven 3.8.1** ou version supérieure

## Configuration du Projet

1. **Cloner le dépôt :**

   git clone https://github.com/bel-zak/produit.service.git
   cd produit.service

Construire le projet :

    mvn clean install
    Lancer l'application :
    mvn spring-boot:run

- L'application démarrera sur : http://localhost:8080.
- Accés Swagger : http://localhost:8080/swagger-ui/index.html#
- lien Actuator : http://localhost:8080/actuator/health
                  http://localhost:8080/actuator/health/custom
                  http://localhost:8080/actuator/metrics
- Endpoints de l'API REST: /api/**
    Afficher les produits :
    URL: GET /api/products/

## initialisation des données ###
- Initialisation des utilisateurs : package com.commerce.produit.service.config
  public InMemoryUserDetailsManager inMemoryUserDetailsManager(){
      PasswordEncoder passwordEncoder= passwordEncoder();
          return new InMemoryUserDetailsManager(
                  User.withUsername("user").password(passwordEncoder.encode("password")).authorities("USER").build(),
                  User.withUsername("admin").password(passwordEncoder.encode("password")).authorities("USER","ADMIN").build()

          );
  }
- Initialisation de la table produit :  
CommandLineRunner commandLineRunner (ProductService productService){
    return args -> {
        for (int i = 0; i < 10; i++) {
            productService.addProduct(
            Product.builder()
            .name("Product- "+i)
            .price(100.00)
            .stockQuantity(13)
            .build());
        }
    };
}
##  les contrats d'interface -- SWAGGER 
- URL : http://localhost:8080/swagger-ui/index.html#


## Authentification ( seul le endpoint DELETE est concerné '/delete/products/{id}' )
Pour accéder aux endpoints protégés (notamment pour la suppression des produits), utilisez les informations de connexion suivantes :

Username: admin
Password: password

