class Solution{

public void insertBottom(Stack<Integer> st,int d){
    if(st.isEmpty()){
        st.push(d);
        return;
    }
    int c=st.pop();
    insertBottom(st,d);
    st.push(c);
}
}

