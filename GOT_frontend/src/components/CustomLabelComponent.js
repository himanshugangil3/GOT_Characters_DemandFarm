const CustomLabelComponent = ({ nodeData }) => {
    return (
      <text
        x={10} // Adjust the horizontal position of the label
        dy=".31em"
        fontSize={12}
        fill="black"
      >
        {nodeData.name}
      </text>
    );
  };

  export default CustomLabelComponent;
  