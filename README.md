# practica-6.1

## Configuracio
La configuracio inicial de la connexio amb la base de dades tindra en compte que la ip será "localhost", l'usuari root, i la contrasneya sera ""(buida).
En cas de voler canviar-ho, s'haura de fer en [classe Connexio](src/src/model/Connexio.java) modificant les variables que indiquen la URL, port, etc...

# Casualistiques
- Afegir una persona amb seguent dades: Pere Pi Pastanaga,M,16-10-1972,57283741H
- Cercar Persones que tinguin el nom de "Carlos" i que el seu primer cognom termini en "ez".
- Modifica la persona id 24 posantli el sexe com 'M' de masculi.
- Eliminar la persona "Pere Pi Pastanaga":
- Mostra la candidatura de la persona_id 2
- Mostra les persones que estiguin en una candidatura
  - Aqui fem servir un INNER JOIN per trovar les persones que pertanyen a una candidatura.
  - Es fa servir un inner join perque d'altre banda s'hauria de sobrecarregar la funcio read de persones, per que admeti nomes id o nomes nom i cognom.
  - Aquesta consulta es troba en una funcio propia en la clase CandidaturesDAODB
  
# Queries d'exemple
- Afegir una persona amb seguent dades: Pere Pi Pastanaga,M,16-10-1972,57283741H
    INSERT INTO persones (nom,cog1,cog2,sexe,data_naixement,dni)   VALUES ( 'Pere','Pi','Pastanaga','M',DATE("1972-10-16"),'57283741H')

- Cercar Persones que tinguin el nom de "Carlos" i que el seu primer cognom termini en "ez".
    SELECT * FROM persones WHERE nom LIKE 'Carlos' AND  cog1 LIKE "%ez%"

- Modifica la persona id 24 posantli el sexe com 'M' de masculi.
    UPDATE persones SET sexe= "M" WHERE persona_id= 24

- Eliminar la persona "Pere Pi Pastanaga":
    DELETE FROM persones WHERE cog2='Pastanaga';

- Mostra la candidatura de la persona_id 2
    SELECT *
    FROM candidatures
    INNER JOIN candidats ON candidats.candidatura_id = candidatures.candidatura_id
    INNER JOIN persones ON persones.persona_id = candidats.persona_id
    WHERE persones.persona_id = 2

- Mostra les persones que estiguin en la candidatura de PSOE
    SELECT * FROM persones
    INNER JOIN candidats ON candidats.persona_id = persones.persona_id
    INNER JOIN candidatures ON candidatures.candidatura_id = candidats.candidatura_id
    WHERE candidatures.nom_curt = 'PSOE'