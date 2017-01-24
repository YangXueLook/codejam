package purestorage;

//''' pure storage buddy system bitmap
//Given a complete binary tree with nodes of values of either 1 or 0, the following rules always hold:
//(1) a node's value is 1 if and only if all its subtree nodes' values are 1
//(2) a leaf node can have value either 1 or 0
//Implement the following 2 APIs:
//set_bit(offset, length), set the bits at range from offset to offset+length-1
//clear_bit(offset, length), clear the bits at range from offset to offset+length-1
//
//i.e. The tree is like:
//             0
//          /     \
//         0        1
//       /  \      /  \
//      1    0    1    1
//     /\   / \   / 
//    1  1 1   0 1
//    Since it's complete binary tree, the nodes can be stored in an array:
//    [0,0,1,1,0,1,1,1,1,1,0,1] 
//    
//'''
//
//def setbit_down(A, x, n):
//if x>=n:
//    return
//if 2*x+1<=n and A[2*x+1]==0:
//    A[2*x+1]=1
//    setbit_down(A,2*x+1,n)
//if 2*x+2<=n and A[2*x+2]==0:
//    A[2*x+2]=1
//    setbit_down(A,2*x+2,n)
//
//
//def set_bit(A, pos, length):
//if not A or pos<0 or length<=0:
//    return
//n = len(A)-1    #last index of A
//for x in range(pos, min(n+1,min(pos+length, 2*pos+1))):
//    # set self
//    if A[x] == 1:
//        continue
//    A[x]=1
//    # set descendants
//    setbit_down(A,x,n)
//    # set ancestors
//    while x>0:
//        # make sure its sibling is 1, if its sibling is 0, cannot set ancestors
//        if (x%2==0 and A[x-1]==1) or (x%2==1 and x<n and A[x+1]==1):
//            A[(x-1)/2] = 1
//        x = (x-1)/2
//
//def clear_bit(A, pos, length):
//if not A or pos<0 or length<=0:
//    return
//n = len(A)-1    #last index of A
//for x in range(pos, min(n+1, pos+length)):
//    # clear self
//    if A[x]==0:
//        continue
//    A[x]=0
//    # clear descendants
//    while 2*x+1<=n:
//        A[2*x+1] = 0
//        x=2*x+1
//    # clear ancestors
//    while x>0:
//        if A[(x-1)/2]==0:
//            break
//        A[(x-1)/2] = 0
//        x = (x-1)/2
//            
//if __name__=='__main__':
//A=[0,0,1,1,0,1,1,1,1,1,0,1]
//test_cases = [(x,y) for x in range(len(A)) for y in range(1,len(A)-x+1)]
//
//for each_test_case in test_cases:
//    pos, length = each_test_case        
//    A=[0,0,1,1,0,1,1,1,1,1,0,1]
//    set_bit(A,pos, length)
//    print 'after setting bit from ', pos, 'for ', length,'A is: ', A
//    A=[0,0,1,1,0,1,1,1,1,1,0,1]
//    clear_bit(A,pos, length)
//    print 'after clearing bit from ', pos, 'for ', length,'A is: ', A


public class BitMapTree {
	
	public static void setChildToOne(int[] array, int parentIndex)
	{
		if(parentIndex > array.length - 1)
			return;
		if(2*parentIndex+1< array.length && array[2*parentIndex+1]==0)
		{
			array[2*parentIndex+1] = 1;
			setChildToOne(array, parentIndex * 2 + 1);
		}
		if(2*parentIndex + 2< array.length && array[2*parentIndex+2]==0)
		{
			array[2*parentIndex+2] = 1;
			setChildToOne(array,parentIndex * 2 + 2);
		}
	}
	
	public static void set_bit(int[] array, int pos, int length)
	{
		if(array == null || pos < 0 || length <= 0)
			return;
		
		for(int i = pos; i - pos < length && i + length < array.length; i++)
		{
			if(array[i] == 1)
				continue;
			else
			{
				array[i] = 1;
				setChildToOne(array, i);
			}
			
			while(i > 0)
			{
				if((i%2 == 0 && array[i - 1] == 1)||(i%2 == 1 && i + 1 < array.length && array[i + 1] == 1))
				{
					array[(i-1)/2] = 1;
					i = i/2;
				}
				else
				{
					break;
				}
			}
		}
	}
	
	public static void clear_bit(int[] array, int pos, int length)
	{
		if(array == null || pos < 0 || length <= 0)
			return;
		
		for(int i = pos; i - pos < length && i + length < array.length; i++)
		{
			if(array[i] == 0)
				continue;
			else
			{
				array[i] = 0;
				int movingDownIndex = i;
				while(2 * movingDownIndex + 1 < array.length)
				{
					array[movingDownIndex] = 0;
					movingDownIndex = 2 * movingDownIndex + 1;
				}
				
				int movingUpIndex = i;
				while(movingUpIndex > 0)
				{
					if(array[(movingUpIndex - 1)/2] == 0)
						break;
					else
					{
						array[(movingUpIndex - 1)/2] = 0;
						movingUpIndex = (movingUpIndex - 1)/2;
					}
					
				}
				
			}
			
		}
	}
	
	
	//def clear_bit(A, pos, length):
	//if not A or pos<0 or length<=0:
//	    return
	//n = len(A)-1    #last index of A
	//for x in range(pos, min(n+1, pos+length)):
//	    # clear self
//	    if A[x]==0:
//	        continue
//	    A[x]=0
//	    # clear descendants
//	    while 2*x+1<=n:
//	        A[2*x+1] = 0
//	        x=2*x+1
//	    # clear ancestors
//	    while x>0:
//	        if A[(x-1)/2]==0:
//	            break
//	        A[(x-1)/2] = 0
//	        x = (x-1)/2
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
