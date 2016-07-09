package ming.MyProject.netty.handler;

import java.util.List;

import ming.MyProject.netty.pojo.UnixTime;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;

public class TimeDecodeHandler extends ReplayingDecoder<UnixTime>{

	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf in,
			List<Object> out) throws Exception {
		if(in.readableBytes()<4){
			return ;
		}
		out.add(new UnixTime(in.readUnsignedInt()));
	}

}
