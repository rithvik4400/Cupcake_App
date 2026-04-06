# 🧁 Cupcake App (Jetpack Compose)

A modern Android application built using **Jetpack Compose** that allows users to order cupcakes with customizable quantity, flavors, and pickup dates.

---

## 🚀 Features

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

## 🧠 Tech Stack

* **Kotlin**
* **Jetpack Compose**
* **MVVM Architecture**
* **StateFlow / ViewModel**
* **Navigation Component (Compose)**

---

## 📱 Screens

1. **Start Screen** – Select quantity
2. **Flavor Screen** – Multi-select flavors
3. **Pickup Screen** – Choose date
4. **Summary Screen** – View & share order

---

## 💰 Pricing Logic

```text
Base Price = ₹25 (per cupcake)

Each extra flavor = ₹10

Total Price Formula:
Total = Quantity × (Base Price + (SelectedFlavors - 1) × Extra Cost)
```

---

## 📸 Screenshots

<img width="1919" height="1015" alt="image" src="https://github.com/user-attachments/assets/a609c532-c214-4659-9590-3c6a6014351b" />
<img width="1919" height="1022" alt="image" src="https://github.com/user-attachments/assets/95103028-a859-42cf-8946-9aca3c0ad9f8" />
<img width="1919" height="1015" alt="image" src="https://github.com/user-attachments/assets/58cba64b-feb1-4c94-b229-da408aaab814" />
<img width="1919" height="1023" alt="image" src="https://github.com/user-attachments/assets/85cde3aa-f17f-4699-b2e4-3e61a4f44b41" />
<img width="1919" height="1018" alt="image" src="https://github.com/user-attachments/assets/fd92c689-0a8f-4bce-a6eb-b7df1d1efe8f" />

---

## ⚙️ Setup Instructions

1. Clone the repositor
2. Open in **Android Studio**
3. Run the app on emulator or device

---

## 🧩 Project Structure

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

##  Future Improvements

*  Chip-style flavor selection UI
*  Payment integration
*  Price breakdown UI
*  Backend integration

---

## 👨‍💻 Author

**Poka Rithvik Chowdary**
📧 [rithvik4400@gmail.com](mailto:rithvik4400@gmail.com)
🔗 GitHub: https://github.com/rithvik4400
🔗 LinkedIn:[ www.linkedin.com/in/poka-rithvik-chowdary-035bb2312](https://www.linkedin.com/in/poka-rithvik-chowdary-035bb2312/)

---

## ⭐ Support

If you like this project, give it a ⭐ on GitHub!
