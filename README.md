DroidText
=========

Originally linked to the Google Code project:

http://code.google.com/p/droidtext/

This is no longer available, however this code is still under a LGPL license, and any changes made to it will also be under the same license.

How to use this library
=========
1. Download the AAR from the releases page
2. In Android studio import the AAR using: File -> New -> New Module -> "Import .JAR or .AAR Package"
3. Add the dependancy to your build file an example is below, but it will depend on what you called your module. (You can check your settings.gradle file to see what to use, since it should be including the module in there.)

```
dependencies {
  compile project(':DroidTextLibrary')
}
```
