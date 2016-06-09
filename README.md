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

# Install

Add it in your root build.gradle at the end of repositories:
```java
 	allprojects {
 		  repositories {
 			 ...
 			 maven { url "https://jitpack.io" }
 		 }
 	}
```
Add the dependency
```java
 	dependencies {
	        compile 'com.github.slmyldz:AndroidRandom:1.0'
	}
```

# License

 ```
The MIT License (MIT)
Copyright (c) 2016 Selim YILDIZ

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
```
