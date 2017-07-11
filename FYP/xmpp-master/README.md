Ubiety XMPP Library
===================

Ubiety is an extensible XMPP library written in C# to be easy and powerful.

[![Build status](https://ci.appveyor.com/api/projects/status/3b7lbwih7rgmsc7a?svg=true)](https://ci.appveyor.com/project/coder2000/xmpp)
[![NuGet version](https://badge.fury.io/nu/UbietyXMPP.svg)](http://badge.fury.io/nu/UbietyXMPP)
[![CLA assistant](https://cla-assistant.io/readme/badge/ubiety/xmpp)](https://cla-assistant.io/ubiety/xmpp)

Installing
----------

Install from NuGet using: Install-Package UbietyXMPP

Example
-------

```c#
using Ubiety;
using Ubiety.Common;

public class Test {
    public static void Main() {
        Xmpp ubiety = new Xmpp();
        ubiety.Settings.ID = new JID("test@ubiety.ca");
        ubiety.Settings.Password = "test";
        
        ubiety.Connect();
    }
}
```
XEPs
----

* XEP-0106 JID Escaping
* XEP-0138 Stream Compression
* XEP-0198 Stream Management (In Progress)

Support
-------

* Forum: <http://community.dieterlunn.ca>
