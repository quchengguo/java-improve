package NIOClientService;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/** 
* @author quchengguo
* @version 2018��3��9�� ����9:50:29 
* NIO Server
*/
public class Service { 
    private Selector selector; 
    private ByteBuffer readBuffer = ByteBuffer.allocate(1024);//��������Ĵ�С���Կ�����ӡ����ı仯 
    private ByteBuffer sendBuffer = ByteBuffer.allocate(1024);//��������Ĵ�С���Կ�����ӡ����ı仯 
 
    String str;
    public void start() throws IOException {
        // �򿪷������׽���ͨ�� 
        ServerSocketChannel ssc = ServerSocketChannel.open(); 
        // ����������Ϊ������ 
        ssc.configureBlocking(false); 
        // ���з���İ� 
        ssc.bind(new InetSocketAddress("chengguo", 8091)); 
        
        // ͨ��open()�����ҵ�Selector
        selector = Selector.open(); 
        // ע�ᵽselector���ȴ�����
        ssc.register(selector, SelectionKey.OP_ACCEPT);
        
        while (!Thread.currentThread().isInterrupted()) { 
            selector.select(); 
            Set<SelectionKey> keys = selector.selectedKeys(); 
            Iterator<SelectionKey> keyIterator = keys.iterator(); 
            while (keyIterator.hasNext()) { 
                SelectionKey key = keyIterator.next(); 
                if (!key.isValid()) { 
                    continue; 
                } 
                if (key.isAcceptable()) { 
                    accept(key); 
                } else if (key.isReadable()) { 
                    read(key); 
                } else if (key.isWritable()) {
                    write(key);
                }
                keyIterator.remove(); //���¼��Ѿ��������Զ���
            } 
        } 
    }

    private void write(SelectionKey key) throws IOException, ClosedChannelException {
        SocketChannel channel = (SocketChannel) key.channel();
        System.out.println("write:"+str);
        
        sendBuffer.clear();
        sendBuffer.put(str.getBytes());
        sendBuffer.flip();
        channel.write(sendBuffer);
        channel.register(selector, SelectionKey.OP_READ);
    } 
 
    private void read(SelectionKey key) throws IOException { 
        SocketChannel socketChannel = (SocketChannel) key.channel(); 
 
        // Clear out our read buffer so it's ready for new data 
        this.readBuffer.clear(); 
//        readBuffer.flip();
        // Attempt to read off the channel 
        int numRead; 
        try { 
            numRead = socketChannel.read(this.readBuffer); 
        } catch (IOException e) { 
            // The remote forcibly closed the connection, cancel 
            // the selection key and close the channel. 
            key.cancel(); 
            socketChannel.close(); 
            
            return; 
        } 
        
        str = new String(readBuffer.array(), 0, numRead);
        System.out.println(str);
        socketChannel.register(selector, SelectionKey.OP_WRITE);
    } 
 
    private void accept(SelectionKey key) throws IOException { 
        ServerSocketChannel ssc = (ServerSocketChannel) key.channel(); 
        SocketChannel clientChannel = ssc.accept(); 
        clientChannel.configureBlocking(false); 
        clientChannel.register(selector, SelectionKey.OP_READ); 
        System.out.println("a new client connected "+clientChannel.getRemoteAddress()); 
    } 
 
    public static void main(String[] args) throws IOException { 
        System.out.println("server started..."); 
        new Service().start(); 
    } 
}
