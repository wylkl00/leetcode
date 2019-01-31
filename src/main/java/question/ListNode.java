package question;

/**
 * Description: 链表
 *
 * @author wangyang
 * @since 2019/1/30
 */

public class ListNode {
    int val;

    ListNode next;

    ListNode(int x) {
        val = x;
    }

    ListNode(int x , ListNode listNode){
        val = x;
        next = listNode;
    }

    ListNode(int...val){
        ListNode node = null ;
        for (int i = val.length - 1; i > 0; i-- ){
            node = new ListNode(val[i],node);
        }
        this.val = val[0];
        this.next = node;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer(String.valueOf(val));
        ListNode nextNode = this.next;
        while (nextNode != null){

            sb.append("->").append(nextNode.val);
            nextNode = nextNode.next;
        }
        return sb.toString();
    }
}
