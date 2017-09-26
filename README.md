# bootcamp-2017-2.latihan-1
Latihan membuat aplikasi web dengan JSP dan Servlet

## Soal

Buatlah aplikasi CRUD (Create Read Update Delete) sederhana dengan studikasus pelayanan rumahsakit yang terkait data master pasien, dokter, rawat inap dll

## Cara mengerjakan

1. Fork repository ini dengan klick tombol `Fork` seperti gambar berikut
2. Setelah di fork, nantinya project ini akan menjadi milik anda sendiri, lalu clone repositorynya ke local konputer anda.
3. Setelah selesai mengerjakan atau waktu habis push ke repository anda masing masing.
4. Tambahkan user `dimMaryanto93` ke collaborators

## Ketentuan & Syarat

* Buat user/role dengan nama `bootcamp_latihan` dengan password `latihan`
* Buat schema dengan nama `latihan_1`
* Boleh buka buku, opensource, internet, video tutorial dll.
* Waktu mengerjakan bebas (tidak harus jam kantor / jam 9 pagi s/d 5 sore)
* Selesai tidak selesai harus di push **max** tanggal **Rabu, 27 September 2017** pukul **24.00**

## Struktur data

1. table pasien

| column name     | data type               | constraints   |
| :-------------  | :-------------          | :-----------  |
| id              | serial                  | primary key, not null, unique |
| nama            | character varying(50)   | not null |
| alamat          | character varying(255)  |  |
| tanggal_lahir   | date                    | not null |

2. table dokter

| column name     | data type               | constraints   |
| :-------------  | :-------------          | :-----------  |
| id              | serial                  | primary key, not null, unique |
| nama            | character varying(50)   | not null |
| spesialis       | character varying(100)  |  |

3. table ruang

| column name     | data type               | constraints   |
| :-------------  | :-------------          | :-----------  |
| id              | serial                  | primary key, not null, unique |
| no_ruangan      | character varying(4)    | not null, unique |
| kosong          | boolean                 | not null, default true |


4. table rawat

| column name     | data type               | constraints   |
| :-------------  | :-------------          | :-----------  |
| id              | serial                  | primary key, not null, unique |
| pasien_id       | integer                 | fk references tab pasien  |
| dokter_id       | integer                 | fk references tab dokter  |
| ruang_id        | integer                 | fk references tab ruang   |
| waktu_register  | timestamp without zone  | not null                  |
| waktu_checkout  | timestamp without zone  | not null                  |


## Waktu penyelesaian (2 Hari)

* Task hari pertama
  * Membuat table master pasien
  * Membuat table master ruang
  * Membuat table master dokter
  * Membuat table transaksi rawat
  * Membuat halaman CRUD di JSP / Servlet untuk table pasien.
* Task hari ke dua
  * Membuat halaman CRUD di JSP/ Servlet untuk struktur data dokter dan ruang.
  * Membuat aplikasi sistem rawat inap rumah sakit.

## Sistem Rawat Inap Rumah sakit

Sistem rawat ini sangat sedarhana, jadi kita hanya membuat sebuah program untuk mendaftarkan pasien yang akan melakukan rawat inap berdasarkan ruang yang **masih tersedia atau kosong** yang mencatat tanggal masuk pasien dan tanggal keluar pasien sebagi log sistem rumah sakit ini.
