<h1 align="center"> 
    <img width="150" src="https://github.com/hangga/BabyBus/blob/main/babybus/baby-icon.png?raw=true"/><br/>
    BabyBus
</h1>
<p align="center">Let's simplify our minds like babies.<br/>Easy way of getting a result from an activity without complicated and rambling 😄<br/></p>


<a target="_blank" href="https://twitter.com/intent/tweet?text=YOUR-TITLE&url=https://github.com/hangga/BabyBus&via=TWITTER-HANDLE">Tweet</a><a target="_blank" href="https://www.facebook.com/sharer/sharer.php?u=https://github.com/hangga/BabyBus">Share on Facebook</a><a target="_blank" href="https://plus.google.com/share?url=https://github.com/hangga/BabyBus">Plus on Google+</a><a target="_blank" href="https://www.linkedin.com/shareArticle?mini=true&url=https://github.com/hangga/BabyBus&title=YOUR-TITLE&summary=YOUR-SUMMARY&source=https://github.com/hangga/BabyBus">Share on LinkedIn</a><a target="_blank" href="https://pinterest.com/pin/create/button/?url=https://github.com/hangga/BabyBus&description=YOUR-DESCRIPTION&media=YOUR-IMAGE-SRC">Pin on Pinterest</a><a target="_blank" href="https://vk.com/share.php?url=https://github.com/hangga/BabyBus&title=YOUR-TITLE&description=YOUR-DESCRIPTION&image=YOUR-IMAGE-SRC&noparse=true">Share on VK</a><a target="_blank" href="https://www.xing-share.com/app/user?op=share;sc_p=xing-share;url=https://github.com/hangga/BabyBus">Share on Xing</a><a target="_blank" href="http://www.tumblr.com/share/link?url=https://github.com/hangga/BabyBus&description=YOUR-DESCRIPTION">Share on Tumblr</a><a target="_blank" href="http://www.reddit.com/submit?url=YOUR_URL&title=YOUR_TITLE">Share on Reddit</a>


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
