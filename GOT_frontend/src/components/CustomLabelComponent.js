const CustomLabelComponent = ({ nodeData }) => {
    return (
      <text
        x={10} //
        dy=".31em"
        fontSize={12}
        fill="black"
      >
        {nodeData.name}
      </text>
    );
  };

  export default CustomLabelComponent;
  
