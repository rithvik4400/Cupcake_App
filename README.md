# 🧁 Cupcake App (Jetpack Compose)

A modern Android application built using **Jetpack Compose** that allows users to order cupcakes with customizable quantity, flavors, and pickup dates.

---

## Features

*  Select cupcake quantity (1, 6, 12)
*  Choose **multiple flavors** (Checkbox support)
*  Select pickup date
*  **Dynamic pricing system** based on:

  * Quantity
  * Number of selected flavors
*  Order summary screen
*  Share order via other apps (Intent)
*  Clean UI using Material 3

---

##  Tech Stack

* **Kotlin**
* **Jetpack Compose**
* **MVVM Architecture**
* **StateFlow / ViewModel**
* **Navigation Component (Compose)**

---

##  Screens

**Start Screen** – Select quantity
 <img width="365" height="767" alt="image" src="https://github.com/user-attachments/assets/710dae59-acfd-4692-8231-5c501fd65f5a" />    
 
 ---
 **Flavor Screen** – Multi-select flavors
 <img width="377" height="769" alt="image" src="https://github.com/user-attachments/assets/c61e7b8d-9d66-482a-ae4f-ff02accaa2e4" />
 
 ----
 **Pickup Screen** – Choose date
 <img width="357" height="767" alt="image" src="https://github.com/user-attachments/assets/c1654a9b-9bb3-4c16-a4cb-d05f09099867" />

 ---
 **Summary Screen** – View & share order
 <img width="373" height="769" alt="image" src="https://github.com/user-attachments/assets/48c9271d-9933-4091-8f98-4654462eea54" />

---

## 💰 Pricing Logic

```text
Base Price = ₹25 (per cupcake)

Each extra flavor = ₹10

Total Price Formula:
Total = Quantity × (Base Price + (SelectedFlavors - 1) × Extra Cost)
```

---

## ⚙️ Setup Instructions

1. Clone the repository

```bash
git clone https://github.com/your-username/cupcake-app.git
```
2. Open in **Android Studio**
3. Run the app on emulator or device

---

## Project Structure

```text
com.example.cupcake
│
├── data/
│   └── DataSource.kt
│
├── ui/
│   ├── StartOrderScreen.kt
│   ├── SelectOptionScreen.kt
│   ├── OrderSummaryScreen.kt
│   ├── OrderViewModel.kt
│
└── MainActivity.kt
```

---

## Future Improvements

*  Chip-style flavor selection UI
*  Payment integration
*  Price breakdown UI
*  Backend integration

---

## 👨‍💻 Author

**Poka Rithvik Chowdary**
📧 [rithvik4400@gmail.com](mailto:rithvik4400@gmail.com)
🔗 GitHub: https://github.com/rithvik4400
🔗 LinkedIn: https://www.linkedin.com/in/your-linkedin-id/

---

## ⭐ Support

If you like this project, give it a ⭐ on GitHub!
