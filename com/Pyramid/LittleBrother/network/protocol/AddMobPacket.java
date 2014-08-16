package com.Pyramid.LittleBrother.network.protocol;

import com.Pyramid.LittleBrother.network.Binary;

class AddMobPacket extends DataPacket{
	public int eid;
	public int type;
	public int x;
	public int y;
	public int z;
	public float pitch;
	public float yaw;
	public byte[] metadata;

	public function pid(){
		return Info::ADD_MOB_PACKET;
	}

	public function decode(){

	}

	public function encode(){
		this.reset();
		this.putInt(eid);
		this.putInt(type);
		this.putInt(x);
		this.putInt(y);
		this.putInt(z);
		this.putByte((byte)floor(yaw * (256 / 360)));
		this.putByte((byte)floor(pitch * (256 / 360)));
		this.put(Binary.writeMetadata(metadata));
	}

}