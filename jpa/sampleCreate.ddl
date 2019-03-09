CREATE TABLE PERSONNE (PERSONNE_NOM VARCHAR(255) NOT NULL UNIQUE, PERSONNE_PRENOM VARCHAR(255) NOT NULL UNIQUE, PRIMARY KEY (PERSONNE_NOM, PERSONNE_PRENOM))
CREATE TABLE CHIEN (SURNOM VARCHAR(255) NOT NULL, CHENIL_NOM VARCHAR(255), nom_maitre VARCHAR(255), prenom_maitre VARCHAR(255), PRIMARY KEY (SURNOM))
CREATE TABLE PATHOLOGIE (NOM VARCHAR(255) NOT NULL, DESCRIPTION VARCHAR(255), CHIEN_SURNOM VARCHAR(255), PRIMARY KEY (NOM))
CREATE TABLE CHENIL (NOM VARCHAR(255) NOT NULL, PRIMARY KEY (NOM))
CREATE TABLE CHIEN_PATHOLOGIE (Chien_SURNOM VARCHAR(255) NOT NULL, pathologie_NOM VARCHAR(255) NOT NULL, PRIMARY KEY (Chien_SURNOM, pathologie_NOM))
CREATE TABLE CHENIL_CHIEN (Chenil_NOM VARCHAR(255) NOT NULL, listChiens_SURNOM VARCHAR(255) NOT NULL, PRIMARY KEY (Chenil_NOM, listChiens_SURNOM))
ALTER TABLE CHIEN ADD CONSTRAINT FK_CHIEN_CHENIL_NOM FOREIGN KEY (CHENIL_NOM) REFERENCES CHENIL (NOM)
ALTER TABLE CHIEN ADD CONSTRAINT FK_CHIEN_nom_maitre FOREIGN KEY (nom_maitre, prenom_maitre) REFERENCES PERSONNE (PERSONNE_NOM, PERSONNE_PRENOM)
ALTER TABLE PATHOLOGIE ADD CONSTRAINT FK_PATHOLOGIE_CHIEN_SURNOM FOREIGN KEY (CHIEN_SURNOM) REFERENCES CHIEN (SURNOM)
ALTER TABLE CHIEN_PATHOLOGIE ADD CONSTRAINT FK_CHIEN_PATHOLOGIE_pathologie_NOM FOREIGN KEY (pathologie_NOM) REFERENCES PATHOLOGIE (NOM)
ALTER TABLE CHIEN_PATHOLOGIE ADD CONSTRAINT FK_CHIEN_PATHOLOGIE_Chien_SURNOM FOREIGN KEY (Chien_SURNOM) REFERENCES CHIEN (SURNOM)
ALTER TABLE CHENIL_CHIEN ADD CONSTRAINT FK_CHENIL_CHIEN_Chenil_NOM FOREIGN KEY (Chenil_NOM) REFERENCES CHENIL (NOM)
ALTER TABLE CHENIL_CHIEN ADD CONSTRAINT FK_CHENIL_CHIEN_listChiens_SURNOM FOREIGN KEY (listChiens_SURNOM) REFERENCES CHIEN (SURNOM)
