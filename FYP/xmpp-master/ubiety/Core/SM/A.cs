﻿// A.cs
//
//Ubiety XMPP Library Copyright (C) 2017 Dieter Lunn
//
//This library is free software; you can redistribute it and/or modify it under
//the terms of the GNU Lesser General Public License as published by the Free
//Software Foundation; either version 3 of the License, or (at your option)
//any later version.
//
//This library is distributed in the hope that it will be useful, but WITHOUT
//ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
//FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
//
//You should have received a copy of the GNU Lesser General Public License along
//with this library; if not, write to the Free Software Foundation, Inc., 59
//Temple Place, Suite 330, Boston, MA 02111-1307 USA

using System.Xml;
using Ubiety.Common;
using Ubiety.Infrastructure.Attributes;

namespace Ubiety.Core.SM
{
    /// <summary>
    ///
    /// </summary>
    [XmppTag("a", Namespaces.StreamManagementV3, typeof(A))]
    public class A : Tag
    {
        /// <summary>
        ///
        /// </summary>
        public A() : base("", new XmlQualifiedName("a", Namespaces.StreamManagementV3)){}

        /// <summary>
        ///
        /// </summary>
        public int H
        {
            get { return int.Parse(GetAttribute("h")); }
            set { SetAttribute("h", value.ToString()); }
        }
    }
}