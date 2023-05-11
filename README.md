# HiKeebs-Back
## Como utilizar nuestro Back
Para utilizar nuestro back, tendras que hacer un `git clone` de nuestro repositorio.
Una vez finalizado el git clone, necesitara varios programas:
**Primero** : Un IDE para lanzar nuestro codigo. En nuestro caso, hemos usado el IDE IntelliJ IDEA Community Edition 2023.1.1
**Segundo** : Para ejecutar nuestro script de base de datos, necesitara el XAMPP en su version 8.2.4 y MySQL WorkBench en su version 8.0
**Tercero** : Para probar los EndPoints de nuestra aplicacion, necesitaremos una plataforma para probar APIs. En nuestro caso, hemos usado Postman.
Cuando tengamos todos los programas necesarios, podremos seguir con la ejecucion de nuestro back.
## Ejecucion del back
Importamos el proyecto en nuestro IDE el proyecto que hemos clonado. Por defecto, el proyecto se encontrara dentro de la carpeta **GitHub** que se encuentra en **Documents/Documentos**
Una vez importado, arrancamos **XAMPP** y encendemos el servicio **Apache** y **MySQL** a la vez, creamos una conexion en MySQL Workbench con el puerto 3306, que es el puerto que utiliza el servicio **MySQL** que hemos arrancado en el **XAMPP**

La creacion de la conexion, es bastante sencilla:
![imagen](https://github.com/SergioGlezRguez/HiKeebs-Back/assets/43896975/b327455b-fbf3-47eb-95e4-519cc7f64d51)
tendremos que dejarla asi, dandole un nombre, (el que queramos), a nuestra conexion.
Dentro del MySQL Workbench, generamos una nueva consulta y cogemos todo el ScriptSQL, lo copiamos y lo pegamos y ejecutamos esa consulta. Lo que hará el script es generar la base de datos `hikeebs` que es la que usa nuestra aplicacion. 

Una vez que tenemos la base de datos con sus tables y sus valores por defecto, podemos inicializar el codigo, para ello vamos a nuestro **IDE** y vamos a la siguiente ruta en nuestro proyecto: **hikeebs -> main -> java -> es.cifpcm.hikeebs -> HikeebsApplication**. Cuando localicemos ese archivo, **Click Derecho -> Run HikeebsApplication....main()**
Una vez este Running, podemos probar todos nuestros Endpoints en el postman.
Un ejemplo para comprobar que funcionan es el siguiente:
![imagen](https://github.com/SergioGlezRguez/HiKeebs-Back/assets/43896975/3c17fe04-d9b9-461f-83cf-b9879f7844c9)

