# Weather Forecast App

Aplikasi Android sederhana untuk menampilkan prakiraan cuaca berdasarkan kota yang dipilih oleh pengguna.

## Deskripsi

Weather Forecast App adalah aplikasi Android sederhana yang memungkinkan pengguna untuk mencari informasi cuaca terkini berdasarkan nama kota. Aplikasi ini dikembangkan untuk tujuan pembelajaran dan demonstrasi unit testing dan instrumental testing pada aplikasi Android.

## Fitur

- Pencarian informasi cuaca berdasarkan nama kota
- Tampilan informasi cuaca yang mencakup:
  - Suhu dalam Celsius
  - Kondisi cuaca
  - Kelembaban
  - Kecepatan angin
- Sistem validasi input kota
- Penanganan kesalahan untuk kota yang tidak ditemukan

## Screenshot

![Weather Forecast App Screenshot](screenshot.png)

## Struktur Projek

Projek ini terdiri dari beberapa komponen utama:

### Kelas Utama

- **MainActivity.java**: Activity utama yang menangani interaksi user dan menampilkan UI.
- **WeatherService.java**: Service class untuk mengambil data cuaca (menggunakan data statis untuk demonstrasi).
- **WeatherData.java**: Model class yang menyimpan data cuaca.

### Testing

Projek ini dilengkapi dengan unit test dan instrumental test:

- **WeatherServiceTest.java**: Unit test untuk class WeatherService
- **MainActivityInstrumentedTest.java**: Instrumental test untuk menguji interaksi UI

## Kota yang Tersedia

Aplikasi ini menyediakan data cuaca statis untuk kota-kota berikut:
- Jakarta
- Bandung
- Surabaya
- Yogyakarta
- Bali

## Cara Menggunakan

1. Masukkan nama kota pada field input
2. Klik tombol "Search Weather"
3. Informasi cuaca akan ditampilkan di layar
4. Jika kota tidak ditemukan, aplikasi akan menampilkan pesan kesalahan

## Implementasi Test

### Unit Test (Local Test)

Aplikasi ini memiliki 4 unit test yang menguji fungsionalitas `WeatherService`:

1. **getWeatherData_forJakarta_returnsCorrectData**: 
   - Memverifikasi data cuaca untuk kota Jakarta
   - Memastikan nilai suhu, kondisi, kelembaban, dan kecepatan angin sesuai

2. **getWeatherData_forNonExistentCity_throwsException**:
   - Memverifikasi bahwa exception dilempar untuk kota yang tidak ada

3. **isValidCity_forExistingCity_returnsTrue**:
   - Memverifikasi validasi kota yang terdaftar

4. **isValidCity_forNonExistentCity_returnsFalse**:
   - Memverifikasi validasi kota yang tidak terdaftar

### Instrumental Test

Aplikasi ini memiliki 2 instrumental test yang menguji interaksi UI:

1. **searchWeather_withValidCity_displaysWeatherInfo**:
   - Memverifikasi tampilan informasi cuaca ketika memasukkan kota yang valid

2. **searchWeather_withInvalidCity_clearsResultView**:
   - Memverifikasi behavior aplikasi ketika memasukkan kota yang tidak valid

## Instalasi

1. Clone repository ini
2. Buka proyek menggunakan Android Studio
3. Sync Gradle
4. Run aplikasi pada emulator atau perangkat Android

## Persyaratan Sistem

- Android Studio Arctic Fox atau lebih baru
- Android SDK minimal API 24 (Android 7.0 Nougat)

## Pengembangan Lebih Lanjut

Untuk pengembangan lebih lanjut, aplikasi ini dapat dikembangkan dengan:
- Integrasi dengan API cuaca nyata seperti OpenWeatherMap
- Menyimpan riwayat pencarian kota
- Menambahkan fitur prakiraan cuaca beberapa hari ke depan
- Menambahkan fitur lokasi saat ini menggunakan GPS

## Kontribusi

Kontribusi selalu diterima. Untuk kontribusi besar, mohon buka issue terlebih dahulu untuk mendiskusikan perubahan yang ingin dilakukan.

## Lisensi

Projek ini dilisensikan di bawah Lisensi MIT - lihat file [LICENSE.md](LICENSE.md) untuk detail lebih lanjut.
