package tw.test.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "member")
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name = "account")
	private String account;
	
	@Column(name = "passwd")
	private String passwd;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "icon")
	private byte[] myicon;
	
	public Member() {};
	public Member(long id, String account, String passwd, String name) {
		this.id = id;
		this.account = account;
		this.passwd = passwd;
		this.name = name;
	}
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public byte[] getMyicon() {
		return myicon;
	}
	public void setMyicon(byte[] myicon) {
		this.myicon = myicon;
	}



	// ---------------------
	@OneToOne(mappedBy = "member", cascade = CascadeType.ALL)
	private MemberInfo memberInfo;

	public MemberInfo getMemberInfo() {
		return memberInfo;
	}
	public void setMemberInfo(MemberInfo memberInfo) {
		this.memberInfo = memberInfo;
		memberInfo.setMember(this);
	}
	
	
	
}
