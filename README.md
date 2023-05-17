# practica-6.1

## Explicació
Aquest projecte demostra la utilitzacio de DAO en un projecte amb una arquitectura MVC. En el modul de model, tenim els models de les classes, i tambe les clases que fan de DAO, es a dir, tenim clases que s'encarreguen de la llogica, i altres acabades en DAODB que s'encarreguen de accedir a les dades per les altres clases.


## Configuració
La configuració inicial de la connexio amb la base de dades tindra en compte que la ip será "localhost", l'usuari root, i la contrasneya sera ""(buida).
En cas de voler canviar-ho, s'haurà de fer en [classe Connexio](src/src/model/Connexio.java) modificant les variables que indiquen la URL, port, etc...

``` java
    private static final String URL = "jdbc:mysql://localhost:3306/jdbc-pt1";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static Connection connexio = null;
```


# Casuístiques
## Persones 
- Afegir una persona introduint: Nom, Primer Cognom, Segon cognom, Sexe (H o F), Data de naixement i DNI
- Cercar Persones fent servir el Nom, Primer Cognom i o Segon Cognom.
- Modifica una persona, introduint les noves dades com si fos una creacio, o guardant "buit" per que no modifiqui res..
- Esborrar una persona

## Candidatures
- Mostra la candidatura de una persona
  - Aqui fem servir un INNER JOIN per trobar les candidatures pertanyen a una persona.
  - Es fa servir un inner join perque d'altre banda s'hauria de sobrecarregar la funcio read de candidatures.
  - Aquesta consulta es troba en una funcio propia en la clase CandidaturesDAODB
- Mostra les persones que estiguin en una candidatura
  - De igual manera que amb la casualistica de trobar les candidatures d'una persona, aquesta es l'inversa. Es a dir, trobar les persones que pertanyen a una candidatura.
  
# Queries d'exemple
- Afegir una persona amb seguent dades: Pere Pi Pastanaga,M,16-10-1972,57283741H
    ``` sql
    INSERT INTO persones (nom,cog1,cog2,sexe,data_naixement,dni)   VALUES ( 'Pere','Pi','Pastanaga','M',DATE("1972-10-16"),'57283741H')
    ```

- Cercar Persones que tinguin el nom de "Carlos" i que el seu primer cognom termini en "ez".
    ``` sql
    SELECT * FROM persones WHERE nom LIKE 'Carlos' AND  cog1 LIKE "%ez%"
    ```

- Modifica la persona id 24 posantli el sexe com 'M' de masculi.
    ``` sql
    UPDATE persones SET sexe= "M" WHERE persona_id= 24
    ```
- Eliminar la persona "Pere Pi Pastanaga":
    ``` sql
    DELETE FROM persones WHERE cog2='Pastanaga';
    ```

- Mostra la candidatura de la persona_id 2
    ``` sql
    SELECT *
    FROM candidatures
    INNER JOIN candidats ON candidats.candidatura_id = candidatures.candidatura_id
    INNER JOIN persones ON persones.persona_id = candidats.persona_id
    WHERE persones.persona_id = 2
    ```
- Mostra les persones que estiguin en la candidatura de PSOE
    ``` sql
    ELECT * FROM persones
    INNER JOIN candidats ON candidats.persona_id = persones.persona_id
    INNER JOIN candidatures ON candidatures.candidatura_id = candidats.candidatura_id
    WHERE candidatures.nom_curt = 'PSOE'
    ```
