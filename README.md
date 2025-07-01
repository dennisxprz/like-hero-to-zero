# 🌍 Like Hero To Zero – CO₂-Emissionsdaten

Dieses Projekt ist ein Prototyp für eine Webanwendung zur Darstellung und Pflege von CO₂-Emissionsdaten weltweit. Zielgruppe sind interessierte Bürger:innen und Forschende.

---

## 🔎 Funktionen

### Öffentlich zugänglich (ohne Login)
- CO₂-Werte nach Land abrufen
- Aktuellster Datensatz eines Landes anzeigen
- Weiterleitung von der Login-Seite zur öffentlichen Ansicht (für Nicht-Forschende)

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

### 🔧 Lokales Setup

Rufe im Browser auf:

Frontend für Bürger:innen:  
http://localhost:8081/co2-app/public.xhtml

Login für Forschende:  
http://localhost:8081/co2-app/login.xhtml

---

## ⚙️ Technologiestack

- Java 11
- Jakarta EE (JSF, CDI, JPA)
- OpenJPA (JPA Provider)
- MySQL (Datenbank) – Achtung: Aktuell konfigurierte DB-Verbindung
- Maven (Projektverwaltung)
- Apache TomEE (Server)

---

## ▶️ Starten der Anwendung

### Voraussetzungen:
- Java JDK 11 oder höher
- Apache TomEE (oder kompatibler Java EE Server)
- Maven
- MySQL-Datenbank (korrekt konfiguriert und gestartet)
- Git (optional)

### Schritte:
```bash
# Projekt klonen
git clone https://github.com/dennisxprz/like-hero-to-zero.git
cd like-hero-to-zero

# Maven Build
mvn clean install

# Deployment auf TomEE (entweder über IDE oder manuell)
