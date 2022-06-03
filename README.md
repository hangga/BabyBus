<h1 align="center"> 
    <img width="150" src="https://github.com/hangga/BabyBus/blob/main/babybus/baby-icon.png?raw=true"/><br/>
    BabyBus
</h1>
<p align="center">Let's simplify our minds like babies.<br/>Easy way of getting a result from an activity without complicated and rambling 😄<br/></p>

### Support API Level
![minsdk](https://img.shields.io/badge/Min%20SDK-API%2024-%233DDC84?logo=android) ![targetsdk](https://img.shields.io/badge/Max%20Support-API%2031-%233DDC84?logo=android)

## Setup
#### 1. Add this repository.
```groovy
maven{url 'https://repo.repsy.io/mvn/hangga/repo'}
```

#### 2. Add this dependency to gradle script on app module. 👉 <a href="https://github.com/hangga/BabyBus/releases">[Latest release]</a>
```groovy
dependencies {
    implementation 'id.web.hangga:babybus:1.0.0' // Please check ☝️ latest version
}
```

## How to Use
### Initialize
Initialize on onCreate Activity or Fragment.

```kotlin
BabyBus babyBus = new BabyBus(this);
```
### Call Intent and get CallBack.
- Using startActivityForResult.
```kotlin
babyBus.startActivityForResult(ModalActivity.class, new BabyResult() {
    @Override
    public void onActivityResult(int resultCode, Intent data) {
        if (resultCode == RESULT_OK){
	  // do something
        }
    }
});
```

- Using startIntent.
```kotlin
Intent i = new Intent(MainActivity.this, ModalActivity.class);
i.putExtra("id_type", "PASSPORT");

babyBus.startIntent(i, new BabyResult() {
    @Override
    public void onActivityResult(int resultCode, Intent data) {
        if (resultCode == RESULT_OK){
	  // do something	
        }
    }
});
```

#### Put Return Data.   
You can put parameter on ModalActivity when finish action.

```kotlin
Intent intent = getIntent();
intent.putExtra("nama", edtNama.getText().toString());
intent.putExtra("alamat", edtAlamat.getText().toString());
intent.putExtra("phone", edtTelp.getText().toString());
setResult(RESULT_OK, intent);
finish();
```
