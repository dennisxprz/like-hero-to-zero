# 🌍 Like Hero To Zero – CO₂-Emissionsdaten

Dieses Projekt ist ein Prototyp für eine Webanwendung zur Darstellung und Pflege von CO₂-Emissionsdaten weltweit. Zielgruppe sind interessierte Bürger:innen und Forschende.

---

## 🔎 Funktionen

### Öffentlich zugänglich (ohne Login)
- CO₂-Werte nach Land abrufen
- Aktuellster Datensatz eines Landes anzeigen

### Login-Bereich für Forschende
- Neue CO₂-Datensätze eintragen
- Bestehende Einträge bearbeiten oder löschen
- Logout-Funktion

---
## 🔐 Login für Wissenschaftler:innen

Um neue CO₂-Daten einzugeben oder bestehende zu bearbeiten, nutzen Sie bitte den folgenden Zugang:

| Feld         | Wert         |
|--------------|--------------|
| Benutzername | forschung    |
| Passwort     | klima2024    |

🔒 Diese Zugangsdaten sind im Prototyp hardcodiert in der `LoginBean.java`.
---

## ⚙️ Technologiestack

- Java 11
- Jakarta EE (JSF, CDI, JPA)
- Hibernate (JPA Provider)
- Apache Derby (Datenbank)
- Maven (Projektverwaltung)
- TomEE (Server)

---

## ▶️ Starten der Anwendung

### Voraussetzungen:
- Java JDK 11 oder höher
- Apache TomEE (oder kompatibler Java EE Server)
- Maven
- Git (optional)

### Schritte:
```bash
# Projekt klonen
git clone https://github.com/dennisxprz/like-hero-to-zero.git
cd like-hero-to-zero

# In Eclipse importieren oder per Maven bauen
mvn clean install
