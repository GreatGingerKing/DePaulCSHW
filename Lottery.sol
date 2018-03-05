pragma solidity ^0.4.0;
contract Lottery {

    struct Player {
        bool played;
        bool won;
        bytes32 blindedPicks;
    }
    
    uint256 private winningNumber;
    uint public guessingEnded;
    uint public lotteryEnded;
    bool public guessEnd;
    
    
    address[] public winningPlayers;
    
    event WinningNumbers(uint256 wN);
    event LotteryEnded(address winner, uint amount);
    event Winner(address winner);

    address public owner;
    ///Players[] players;
    mapping(address => Player) players; ///Create a new Lottery and create the winning number.
    
    function Lottery(uint _guessingTime, uint _confirmationTime) public {
        guessingEnded = now + _guessingTime;
        lotteryEnded = now + _guessingTime + _confirmationTime;
        owner = msg.sender;
        //winningNumber = (uint (keccak256 (block.timestamp))) % 101;
        winningNumber = 57;
    }

   


    /// Give a single vote to proposal $(toProposal).
    function play(bytes32 blindedguess) external payable {
        require(now<guessingEnded);
        require(msg.value ==.001 ether);
        Player storage player = players[msg.sender];
        if (player.played) return;
        player.played = true;
        player.blindedPicks = blindedguess;
    }

    function Verify(uint trueGuess) public returns(bool good){
        //require(now>guessingEnded);
        require(now<lotteryEnded);
        require(!players[msg.sender].won);
        if(players[msg.sender].blindedPicks == keccak256(trueGuess) && trueGuess ==winningNumber){
            ///require(!(msg.sender in winningPlayers));
            winningPlayers.push(msg.sender);
            good=true;
            players[msg.sender].won=true;
            Winner(msg.sender);
        }
    }
    
    function endPickStage() public{
        require(msg.sender==owner);
        require(now>guessingEnded);
        require(!guessEnd);
        guessEnd = true;
        WinningNumbers(winningNumber);
    }
    
    function showWinners() public{
        for(uint8 i=0; i<winningPlayers.length; i++ ){
            Winner(winningPlayers[i]);
        }
       
        
    }
    
    function  hashNumber(uint number) public returns(bytes32 hnumber) {
        hnumber = keccak256(number);
    }
   
   function EndLottery() public{
        require(now >= lotteryEnded); 
        require(msg.sender==owner);
       
        uint winnings=this.balance;
        winnings =uint(9*winnings/(10*winningPlayers.length));
        
        for(uint i=0; i<winningPlayers.length; i++){
            
            winningPlayers[i].transfer(winnings);
            Winner(winningPlayers[i]);
        }
        owner.transfer(this.balance);
        selfdestruct(owner);
        
        
   
   }
}