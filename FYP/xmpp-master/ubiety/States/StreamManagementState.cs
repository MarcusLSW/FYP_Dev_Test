﻿// StreamManagementState.cs
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

using Ubiety.Common;
using Ubiety.Core.SM;
using Ubiety.Registries;

namespace Ubiety.States
{
    /// <summary>
    ///
    /// </summary>
    public class StreamManagementState : IState
    {
        /// <summary>
        /// 
        /// </summary>
        /// <param name="data"></param>
        public void Execute(Tag data = null)
        {
            if (data == null)
            {
                var enable = TagRegistry.GetTag<Enable>("enable", Namespaces.StreamManagementV3);
                ProtocolState.Socket.Write(enable);
            }
            else
            {
                ProtocolState.State = new RunningState();
            }
        }
    }
}