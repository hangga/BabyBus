<h1 align="center"> 
    <img width="100" src="https://github.com/hangga/BabyBus/blob/main/babybus/baby-icon.png?raw=true"/><br/>
    BabyBus
</h1>
<p align="center">Let's simplify our minds like babies.<br/>Easy way of getting a result from an activity without complicated and rambling 😄<br/>
	Please share with.<br/>
<a style="margin: 5px"  target="_blank" href="https://twitter.com/intent/tweet?text=BabyBus&url=https://github.com/hangga/BabyBus&via=TWITTER-HANDLE"><img width="30"  src="https://camo.githubusercontent.com/35b0b8bfbd8840f35607fb56ad0a139047fd5d6e09ceb060c5c6f0a5abd1044c/68747470733a2f2f6564656e742e6769746875622e696f2f537570657254696e7949636f6e732f696d616765732f7376672f747769747465722e737667"/></a> <a style="margin: 5px"  target="_blank" href="https://www.facebook.com/sharer/sharer.php?u=https://github.com/hangga/BabyBus"><img width="30" src="https://camo.githubusercontent.com/8f245234577766478eaf3ee72b0615e99bb9ef3eaa56e1c37f75692811181d5c/68747470733a2f2f6564656e742e6769746875622e696f2f537570657254696e7949636f6e732f696d616765732f7376672f66616365626f6f6b2e737667"/></a> <a style="margin: 5px"  target="_blank" href="https://plus.google.com/share?url=https://github.com/hangga/BabyBus">
<img width="30" src="https://camo.githubusercontent.com/15fdf0cbd71e1ca3db22839bf80a55d246e4a19e4a019021fdf121e2cc193488/68747470733a2f2f6564656e742e6769746875622e696f2f537570657254696e7949636f6e732f696d616765732f7376672f676f6f676c655f706c75732e737667"/></a> <a style="margin: 5px"  target="_blank" href="https://www.linkedin.com/shareArticle?mini=true&url=https://github.com/hangga/BabyBus&title=BabyBus&summary=Easy way of getting a result from an activity without complicated and rambling 😄&source=https://github.com/hangga/BabyBus">
<img width="30" src="https://camo.githubusercontent.com/c8a9c5b414cd812ad6a97a46c29af67239ddaeae08c41724ff7d945fb4c047e5/68747470733a2f2f6564656e742e6769746875622e696f2f537570657254696e7949636f6e732f696d616765732f7376672f6c696e6b6564696e2e737667"/></a> <a style="margin: 5px"  target="_blank" href="https://pinterest.com/pin/create/button/?url=https://github.com/hangga/BabyBus&description=Easy way of getting a result from an activity without complicated and rambling 😄"><img width="30"  src="https://camo.githubusercontent.com/ef99a09dfa010e68c26ec4414631a47bbc1086677227bd97538d051b8b93ae21/68747470733a2f2f6564656e742e6769746875622e696f2f537570657254696e7949636f6e732f696d616765732f7376672f70696e7465726573742e737667"/></a> <a style="margin: 5px"  target="_blank" href="http://www.tumblr.com/share/link?url=https://github.com/hangga/BabyBus&description=Easy way of getting a result from an activity without complicated and rambling 😄"><img width="30" src="https://camo.githubusercontent.com/f47b844e7015760d6fd9c1fb86834af2cf82d215fc9c20c24edc8173c85059a1/68747470733a2f2f6564656e742e6769746875622e696f2f537570657254696e7949636f6e732f696d616765732f7376672f74756d626c722e737667"/></a>
</p>

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
Initialize on onCreate Activity or Fragment.<br/><br/>
![java](https://img.shields.io/badge/-Java-%23B07119)  
```kotlin
BabyBus babyBus = new BabyBus(this);
```
![kotlin](https://img.shields.io/badge/-Kotlin-%23BA00BB)
```kotlin
var babyBus = BabyBus(this)
```
### Call Intent and get CallBack.
#### Using startActivityForResult.
![java](https://img.shields.io/badge/-Java-%23B07119)
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
![kotlin](https://img.shields.io/badge/-Kotlin-%23BA00BB)
```kotlin
babyBus!!.startActivityForResult(ModalActivity::class.java, { i, data ->
    if (i == RESULT_OK) {
        // do something
    }
})
```
#### Using startIntent.
![java](https://img.shields.io/badge/-Java-%23B07119)  
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
![kotlin](https://img.shields.io/badge/-Kotlin-%23BA00BB)
```kotlin
babyBus!!.startIntent(intent, { i, data ->
    if (i == RESULT_OK) {
        // do something
    }
})
```

#### Put Return Data.   
You can put parameter on ModalActivity when finish action.<br/><br/>
![java](https://img.shields.io/badge/-Java-%23B07119)
```kotlin
Intent intent = getIntent();
intent.putExtra("nama", edtNama.getText().toString());
intent.putExtra("alamat", edtAlamat.getText().toString());
intent.putExtra("phone", edtTelp.getText().toString());
setResult(RESULT_OK, intent);
finish();
```
![kotlin](https://img.shields.io/badge/-Kotlin-%23BA00BB)
```kotlin
val intent = intent
intent.putExtra("nama", edtNama.text.toString())
intent.putExtra("alamat", edtAlamat.text.toString())
intent.putExtra("phone", edtTelp.text.toString())
setResult(RESULT_OK, intent)
finish()
```
### Sample Project
- <a href="https://github.com/hangga/BabySample">See Sample [in Kotlin]</a>
