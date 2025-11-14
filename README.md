
# Virtual Pet Game - Pet Simulator



## 📖 Deskiripsi Game

Virtual Pet Game adalah game console-based sederhana yang memungkinkan pemain untuk merawat dan berinteraksi dengan hewan peliharaan virtual. Pemain dapat memilih antara anjing, kucing, atau kelinci, kemudian merawatnya dengan memberi makan, bermain, membersihkan, dan menggunakan berbagai item.




## 🎯 Tujuan Proyek

- Menerapkan konsep Pemrograman Berorientasi Objek (OOP) dalam Java
- Membuat console-based game sederhana namun tetap interaktif dan mudah dipahami
- Pemenuhan tugas mini project Pemrograman Berorientasi Objek
- Melatih pemahaman lebih lanjut dalam lingkup OOP


## 👥 Authors

Disini saya mengerjakan secara individu
- Fernandhito Dian Pratama (3124510004) [@nandhitooo](https://github.com/nandhitooo)


## 🛠 Teknologi Yang Digunakan

- **Programming Language:** Java
- **Paradigm:** Object-Oriented Programming
- **Platform:** Console/Text-Based
- **Tools:** Scanner untuk input dan Random untuk sistem event

## 🎮 Fitur Game
 ### ✨ Fitur Utama:
 1. **Multiple Pet Type:** Ada Dog🐶, Cat🐱, dan Rabbit🐰 yang memiliki behavior berbeda
 2. **Need System:** 5 kebutuhan utama (Health, Happiness, Hunger, Cleanliness, Energy)
 3. **Inventory System:** Untuk menyimpan item seperti makanan, mainan, dan obat-obatan
 4. **Day Cycle:** Sistem hari dengan stat decay alami
 5. **Random Events:** Untuk menambah variasi gameplay
 6. **Scoring System:** Sistem skor berdasarkan dengan kondisi Pet
 7. **Species-Specific Interaction:** Interaksi berbeda berdasarkan spesies Pet

 ### 🐕‍🦺 Jenis Hewan Peliharaan 
 1. **Dog🐶:** Loyal terhadap pemilik
 2. **Cat🐱:** Mempunyai sifat seperti majikan 
 3. **Rabbit🐰:** Mempunyai rasa ingin tahu yang tinggi

 ### 🛒 Item yang Tersedia
 1. **Food:** Regular food, Premium food, dan Favorite food
 2. **Toy:** Ball, Yarn Ball, dan Tunnel
 3. **Medicine:** Health potion yang digunakan untuk menyembuhkan Pet ketika sakit
 
## 📁 Struktur Folder
### 📂 Struktur Proyek

Berikut adalah tata letak folder dan file utama dalam proyek ini:

- 📂UML_Diagram/
- ├── UML_Diagram.drawio
- └── UML_Diagram.png
- Cat.java
- Dog.java
- Food.java
- Item.java
- Main.java
- Medicine.java
- Need.java
- Pet.java
- Player.java
- Rabbit.java
- Toy.java
- VirtualPet.java
## 🎯 Cara Bermain

**Alur Game Dasar**
1. **Mulai Game:** Masukkan nama pemain dan pilih hewan peliharaan
2. **Rawat Pet:** Gunakan menu untuk berinteraksi dengan hewan
3. **Kelola Kebutuhan:** Jaga semua stat di level optimal
4. **Gunakan Item:** Pakai inventory untuk efek spesial
5. **Lanjutkan Hari:** Setiap sleep akan memajukan waktu
6. **Capai Target:** Bertahan selama 10 hari atau dapatkan skor tinggi


## 🏆 Kondisi Menang/Kalah

### 🎉 Menang
- **Survive 10 hari** dengan kondisi pet masih hidup
- **Skor Tinggi** menunjukkan kamu merawat pet dengan baik

### 💀 Kalah
- **Health = 0** -> pet kamu mati
- **Critical** terlalu lama
## 💻 Implementasi OOP

✅ Class & Object (6+ Class)
- Main, VirtualPetGame, Player, Pet, Item, dan turunannya

✅ Inheritance
- Pet ← Dog, Cat, Rabbit
- Item ← Food, Toy, Medicine

✅ Polymorphism
- Method getSound(), use(), showStatus() di-override
- Interface-like behavior dengan abstract methods

✅ Encapsulation
- Semua atribut private dengan getter/setter
- Kontrol akses yang tepat untuk setiap field

✅ Association
- Player memiliki Pet dan List<Item>
- Pet memiliki List<Need>

✅ Composition
- VirtualPetGame mengatur lifecycle semua object
- Need objects dibuat dalam Pet
## 🧪 Testing
**Test Case yang Dilakukan**
1. **Pet Creation** -> Berhasil membuat berbagai jenis pet
2. **Stat Management** -> Perubahan stat bekerja dengan benar
3. **Inventory System** -> Item dapat dibeli dan digunakan
4. **Day Progression** -> Hari berjalan dengan baik
5. **Game Over Conditions** -> Win/lose condition terpicu
## 📞 Kontak dan Support
Untuk pertanyaan atau issues terkait project ini, silakan hubungi:

- Email: [dhitopratama2005@gmail.com]
- Repository: [https://github.com/nandhitooo/Virtual-Pet-Games-Java]
## 📄 License
Project ini dibuat untuk memenuhi tugas **Pemrograman Berorientasi Objek**. Educational purposes only.


### Selamat Bermain! 🐾
Take a good care of your pet guys😁😁😀
