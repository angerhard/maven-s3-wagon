/**
 * Copyright 2010-2015 The Kuali Foundation
 *
 * Licensed under the Educational Community License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.opensource.org/licenses/ecl2.php
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.andreasgerhard.maven.wagon;

import java.util.ArrayList;
import java.util.List;

import org.apache.maven.wagon.events.SessionEvent;
import org.kuali.common.aws.s3.SimpleFormatter;

/**
 * Holds timing and byte count information about a transfer operation
 *
 * @author Jeff Caddel
 *
 * @since May 27, 2010 6:51:19 PM
 */
public class SessionTracker {
	SimpleFormatter formatter = new SimpleFormatter();
	List<TransferTracker> transfers = new ArrayList<TransferTracker>();
	List<SessionEvent> sessionEvents = new ArrayList<SessionEvent>();
	long opened;
	long loggedIn;
	long disconnecting;
	long loggedOff;
	long disconnected;

	public TransferTracker getCurrentTransfer() {
		if (transfers.size() == 0) {
			return null;
		} else {
			return transfers.get(transfers.size() - 1);
		}
	}

	public void addSessionEvent(SessionEvent sessionEvent) {
		sessionEvents.add(sessionEvent);
	}

	public void addTransfer(TransferTracker transfer) {
		transfers.add(transfer);
	}

	public List<TransferTracker> getTransfers() {
		return transfers;
	}

	public void setTransfers(List<TransferTracker> transfers) {
		this.transfers = transfers;
	}

	public List<SessionEvent> getSessionEvents() {
		return sessionEvents;
	}

	public void setSessionEvents(List<SessionEvent> sessionEvents) {
		this.sessionEvents = sessionEvents;
	}

	public SimpleFormatter getFormatter() {
		return formatter;
	}

	public void setFormatter(SimpleFormatter formatter) {
		this.formatter = formatter;
	}

	public long getOpened() {
		return opened;
	}

	public void setOpened(long opened) {
		this.opened = opened;
	}

	public long getLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(long loggedIn) {
		this.loggedIn = loggedIn;
	}

	public long getDisconnecting() {
		return disconnecting;
	}

	public void setDisconnecting(long disconnecting) {
		this.disconnecting = disconnecting;
	}

	public long getLoggedOff() {
		return loggedOff;
	}

	public void setLoggedOff(long loggedOff) {
		this.loggedOff = loggedOff;
	}

	public long getDisconnected() {
		return disconnected;
	}

	public void setDisconnected(long disconnected) {
		this.disconnected = disconnected;
	}

}
