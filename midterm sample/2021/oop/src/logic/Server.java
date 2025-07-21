package logic;

import java.util.ArrayList;

public class Server { //36.57 min
	private String name;
	private User owner;
	private ArrayList<Channel> channelList;
	private ArrayList<User> memberList;
	
	public Server(String name, User owner, TemplateType template) {
		this.setName(name);
		this.owner = owner;
		this.channelList = new ArrayList<>();
		this.memberList = new ArrayList<>();
		
		this.addUser(owner);
		Channel newchannel = null;
		if (template == TemplateType.BASIC) {
			newchannel = new Channel("general");
		} else if (template == TemplateType.GAMING) {
			newchannel = new Channel("gaming");
		} else if (template == TemplateType.STUDY) {
			newchannel = new Channel("homework-help");
		}
		this.channelList.add(newchannel);
	}
	
	public Channel addChannel(User user, String channelName) {
		Channel target = null;
		if (this.getOwner().equals(user)) {
			target = new Channel(channelName);
			this.channelList.add(target);
		}
		return target;
	}
	
	public User addUser(User user) {
		User target = null;
		if (!this.memberList.contains(user)) {
			this.memberList.add(user);
			user.getJoinedServersList().add(this);
			target = user;
		}
		return target;
	}
	
	public boolean kickUser(User kicker, User kicked) throws Exception {
		boolean result = false;
		if (!this.getOwner().equals(kicker)) {
			throw new Exception();
		} else if (this.getOwner().equals(kicker) && (!this.memberList.contains(kicked) || this.getOwner().equals(kicked))) {
			result = false;
		} else {
			kicked.getJoinedServersList().remove(this);
			this.memberList.remove(kicked);
			result = true;
		}
		return result;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name.isBlank()) {
			this.name = "Citron home";
		} else {
			this.name = name;
		}
	}

	public User getOwner() {
		return owner;
	}

	public ArrayList<Channel> getChannelList() {
		return channelList;
	}

	public ArrayList<User> getMemberList() {
		return memberList;
	}
	
	
}
