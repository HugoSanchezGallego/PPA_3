# Prueba Programación Android 2 - Ejercicio 3

# [Repositorio](https://github.com/HugoSanchezGallego/PPA_3.git)

Este proyecto es una aplicación de Android que permite a los usuarios buscar farmacias y ver su ubicación en un mapa. A continuación se detalla el funcionamiento de cada una de las clases y archivos del proyecto.

## Índice

1. [MainActivity](#mainactivity)
2. [MapActivity](#mapactivity)
3. [Farmacia](#farmacia)
4. [FarmaciaResponse](#farmaciaresponse)
5. [FarmaciaAdapter](#farmaciaadapter)
6. [fetchFarmacias.kt](#fetchfarmaciaskt)
7. [farmacias.json](#farmaciasjson)
8. [activity_main.xml](#activity_mainxml)
9. [activity_map.xml](#activity_mapxml)
10. [item_farmacia.xml](#item_farmaciaxml)
11. [AndroidManifest.xml](#androidmanifestxml)
12. [build.gradle.kts](#buildgradlekts)

## MainActivity

`MainActivity` es la actividad principal de la aplicación. Se encarga de mostrar la lista de farmacias y manejar la interacción del usuario. Utiliza un `RecyclerView` para mostrar las farmacias y un `FarmaciaAdapter` para enlazar los datos.

### Firebase Integration

Inicializar Firebase en la clase `MainActivity`:

```kotlin
import com.google.firebase.FirebaseApp

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        FirebaseApp.initializeApp(this)
    }
}
```

## MapActivity

`MapActivity` es la actividad que se encarga de mostrar la ubicación de una farmacia en Google Maps. Recibe una descripción de la farmacia a través de un `Intent` y abre Google Maps con la ubicación correspondiente.

## Farmacia

`Farmacia` es una clase de datos que representa una farmacia. Contiene propiedades como el nombre, dirección y coordenadas de la farmacia.

## FarmaciaResponse

`FarmaciaResponse` es una clase que representa la respuesta de la API que devuelve la lista de farmacias. Contiene una lista de objetos `Farmacia`.

## FarmaciaAdapter

`FarmaciaAdapter` es un adaptador para el `RecyclerView` que muestra la lista de farmacias. Se encarga de enlazar los datos de cada farmacia a las vistas correspondientes en el `RecyclerView`.

## fetchFarmacias.kt

`fetchFarmacias.kt` es un archivo que contiene la lógica para obtener la lista de farmacias desde un archivo JSON o una API. Utiliza una función para leer el archivo `farmacias.json` y parsear los datos en una lista de objetos `Farmacia`.

### Firebase Integration

Utilizar Firebase Firestore para almacenar y recuperar datos de farmacias:

```kotlin
import com.google.firebase.firestore.FirebaseFirestore

class FirestoreService {
    private val db = FirebaseFirestore.getInstance()

    fun getFarmacias(callback: (List<Farmacia>) -> Unit) {
        db.collection("farmacias")
            .get()
            .addOnSuccessListener { result ->
                val farmacias = result.map { document ->
                    document.toObject(Farmacia::class.java)
                }
                callback(farmacias)
            }
    }
}
```

## farmacias.json

`farmacias.json` es un archivo JSON que contiene la lista de farmacias con sus respectivas propiedades como nombre, dirección y coordenadas.

## activity_main.xml

`activity_main.xml` es el archivo de diseño para `MainActivity`. Define el `RecyclerView` que muestra la lista de farmacias.

## activity_map.xml

`activity_map.xml` es el archivo de diseño para `MapActivity`. Contiene un `TextView` que muestra un mensaje de "Loading Map..." mientras se carga la ubicación en Google Maps.

## item_farmacia.xml

`item_farmacia.xml` es el archivo de diseño para cada elemento de la lista de farmacias en el `RecyclerView`. Define la estructura y apariencia de cada item de farmacia.

## AndroidManifest.xml

`AndroidManifest.xml` es el archivo de manifiesto de la aplicación. Define las actividades, permisos y otros componentes esenciales de la aplicación.

## build.gradle.kts

`build.gradle.kts` es el archivo de configuración de Gradle para el proyecto. Contiene las dependencias y configuraciones necesarias para compilar y ejecutar la aplicación.

### Firebase Integration

Agregar las dependencias necesarias en el archivo `build.gradle.kts`:

```kotlin
dependencies {
    implementation("com.google.firebase:firebase-auth:21.0.1")
    implementation("com.google.firebase:firebase-firestore:24.0.1")
    implementation("com.google.firebase:firebase-analytics:20.0.2")
}
```
