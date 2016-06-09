# AndroidRandom
Simple random data generator for Android

```java
 //return random int >=a  and <= b
 Randoms.Integer(a,b);
 
 //return random float >=a  and <= b
 Randoms.Float(a,b);
 
 //return random float >=a  and <= b
 Randoms.Double(a,b);
 
 //return random boolean true or false
 Randoms.Boolean();
 
 //return random alphanumeric string as length = a
 Randoms.alphaNumericString(a);
 
 //return random date before
 Randoms.dateBefore();
 
 //return random date after
 Randoms.dateAfter();
 
 //return random url top 100 websites
 Randoms.url(context);
 
 //return random firstname lastname
 Randoms.name(context);
 
 //return random firstname lastname with english Honorific
 Randoms.nameWithEnglishHonorific(context)
 
 //return random gender female or male
 Randoms.gender();
 
 //return random chuck norris jokes fetched from www.icndb.com 
 Randoms.sentence(context);
 
 //return random currency
 Randoms.currency(context);
 
 //return random cat images url from thecatapi.com types as gif png jpg
 Randoms.imageUrl(type);
 
 //return random cat images bitmap from thecatapi.com types as gif png jpg
 Randoms.imageUrl(BitmapListener listener , type);
 
 //return random images url with width and heigth
 Randoms.imageUrl(width,heigth);
 
 //return random cat gif as byte[] from thecatapi.com
 Randoms.imageGif(GifListener listener);
 
 //return random cat gif as bitmap with width and heigth
 Randoms.image(BitmapListener listener,width,height);
 
 //return placeholder image url from placeholdit.imgix.net
 Randoms.imagePlaceholderUrl(String text,int textSize,int width,int height);
 
 //return placeholder image bitmap from placeholdit.imgix.net
 Randoms.imagePlaceholder(BitmapListener listener,String text,int textSize,int width,int height);

 //return random avatar image url from www.avatarpro.biz
 Randoms.imageAvatarUrl(size);
 
 //return random avatar image bitmap from www.avatarpro.biz
 Randoms.imageAvatar(BitmapListener listener,size);
 
 //return random email like tamhager55@example.com
 Randoms.email(context);
 
```
